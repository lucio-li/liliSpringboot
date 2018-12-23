var app = getApp();
var replyObj = {};
var openid = "";
var emojiChar = "😋-😌-😍-😏-😜-😝-😞-😔-😪-😭-😁-😂-😃-😅-😆-👿-😒-😓-😔-😏-😖-😘-😚-😒-😡-😢-😣-😤-😢-😨-😳-😵-😷-😸-😻-😼-😽-😾-😿-🙊-🙋-🙏-✈-🚇-🚃-🚌-🍄-🍅-🍆-🍇-🍈-🍉-🍑-🍒-🍓-🐔-🐶-🐷-👦-👧-👱-👩-👰-👨-👲-👳-💃-💄-💅-💆-💇-🌹-💑-💓-💘-🚲";
var currentPage = 1;
var pageSize = 10;
var hasNext = true;
Page({
  data: {
    basepath: app.globalData.basepath,
    userInfo: {},
    hasUserInfo: false,
    moments: null,
    commentShow: false, //评论的输入框是否显示
    focus: false,
    canIUse: false,
    inputShowed: false,
    content: "", //评论的内容
    inputVal: "",
    grids: [0, 1, 2, 3, 4, 5, 6, 7, 8],
    authorizeShow: false, //授权窗口是否显示  
    emojiList:[],
    replyPlaceholder: "我要评论"

  },
  //事件处理函数,跳转上传照片
  bindViewTap: function() {
    wx.navigateTo({
      url: '../upload/upload'
    })
  },
  onLoad: function() {
    var that = this;
    this.getMomentsList();
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        openid = res.data
      },
    })
    var emojiList = emojiChar.split("-");
    this.setData({
      emojiList: emojiList
    })

    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          winWidth: res.windowWidth,
          winHeight: res.windowHeight
        });
      }
    });
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    // this.getMomentsList();
    this.getUserInfo();


  },
  /**
   * 授权获取用户信息
   */
  getUserInfo: function() {
    var that = this;
    wx.getUserInfo({
      success: function(res) {
        var userInfo = res.userInfo
        var nickName = userInfo.nickName
        var avatarUrl = userInfo.avatarUrl
        that.updateUser(nickName, avatarUrl);
      },
      fail: function() {
        that.setData({
          authorizeShow: true
        })
      }
    })
  },
  getUserMessage: function(data) {
    console.log(data)
    var userInfo = JSON.parse(data.detail.rawData)
    var nickName = userInfo.nickName
    var avatarUrl = userInfo.avatarUrl
    this.setData({
      authorizeShow: false
    })
    this.updateUser(nickName, avatarUrl);
  },
  /**
   * 新增或者更新用户
   */
  updateUser: function(nickName, avatarUrl) {
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        var options = {
          name: nickName,
          openid: res.data,
          headImg: avatarUrl
        };
        var opp = {};
        opp.url = "/server/user/add";
        opp.data = options;
        opp.method = 'POST'
        opp.header = {
          "Content-Type": "application/json"
        };
        app.networkRequestHide(opp, function(res) {
          if (res.data.code == 0) {

          } else {
            console.log("更新用户头像等信息失败");
          }
        })
      },
      fail: function() {
        wx.showModal({
          title: '提示',
          content: '获取openid失败',
          showCancel: false
        })
      }
    })

  },
  //获取所有朋友圈动态的内容
  getMomentsList: function() {
    var that = this;
    var options = {};
    options.currentPage = currentPage;
    options.pageSize = pageSize;
    var opp = {};
    opp.url = "moments/list";
    opp.data = options;
    opp.header = {
      "Content-Type": "application/json"
    };
    app.networkRequest(opp, function(res) {
      if (res.data) {
        var moments = res.data.datas;
        if (moments.length < pageSize) {
          hasNext = false;
        } else {
          hasNext = true;
        }
        var momentsPage = that.data.moments;
        if (!momentsPage) {
          momentsPage = [];
        }
        momentsPage = momentsPage.concat(moments);
        that.setData({
          moments: momentsPage
        })
      } else {
        // that.getMomentsList();
      }

    })
  },

  //下一页
  moreMoments: function() {
    console.log("底部")
    if (hasNext) {
      currentPage++;
      this.getMomentsList();
    }
  },
  /**
   * 图片预览
   */
  previewImage: function(e) {
    var that = this;
    var index = e.currentTarget.dataset.index;
    var images = e.currentTarget.dataset.images;
    var pictures = [];
    for (var i = 0; i < images.length; i++) {
      pictures.push(that.data.basepath + "/moments/attach?attachId=" + images[i]);
    }
    wx.previewImage({
      current: pictures[index],
      urls: pictures,
      fail: function() {

      },
      complete: function() {

      },
    })
  },
  /**
   * 删除动态
   */
  deleteMoment: function(e) {
    var id = e.currentTarget.dataset.id;
    var content = e.currentTarget.dataset.content;
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确定要删除:' + content,
      success: function(sm) {
        if (sm.confirm) {
          // 用户点击了确定 可以调用删除方法了

          var options = {};
          var opp = {};
          opp.url = "moments/" + id;
          opp.data = options;
          opp.method = "PUT";
          opp.header = {
            "Content-Type": "application/json"
          };
          app.networkRequest(opp, function(res) {
            //删除成功重新加载数据
            that.getMomentsList();
          })



        } else if (sm.cancel) {
          console.log('用户点击取消')
        }
      }
    })
  },
  /**
   * 评论输入框失去焦点隐藏
   */
  bindBlurComment: function() {
    this.setData({
      commentHidden: true,
      focus: false
    })
  },
  /**
   * 发送评论的消息
   */
  sendComment: function() {
    var that = this;
    if (!this.data.content) {
      wx.showToast({
        title: '评论的内容不能为空',
        icon: "none"
      })
      return;
    }
    var options = {
      momentsId: replyObj.id,
      contentDetail: this.data.content,
      creator: openid
    };
    if (replyObj.aimUser) {
      options.aimUser = replyObj.aimUser;
    }
    var opp = {};
    opp.url = "comments/add";
    opp.data = options;
    opp.method = "post";
    opp.header = {
      "Content-Type": "application/json"
    };
    app.networkRequestHide(opp, function(res) {
      if (res.data.code == 0) {
        wx.showModal({
          title: '提示',
          showCancel: false,
          content: '评论成功'
        })
        that.setData({
          isShow: false,
          cfBg: false,
          isLoad: false,
          commentShow: false
        })
        that.getMomentsList();
      } else {
        wx.showModal({
          title: '提示',
          content: '评论失败， 是否重试',
          success: function(res) {
            if (res.confirm) {
              that.sendComment()
            }
          }
        })
      }


    })



  },
  /**
   * 评论输入框的改变事件
   */
  textAreaBlur: function(e) {
    this.setData({
      content: e.detail.value
    })
  },

  /**
   * 页面相关事件处理函数--监听下拉刷新
   */
  onPullDownRefresh: function() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getMomentsList();
  },
  showInput: function() {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function() {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function() {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function(e) {
    this.setData({
      inputVal: e.detail.value
    });
  },
  //点击表情显示隐藏表情盒子
  emojiShowHide: function() {
    this.setData({
      isShow: !this.data.isShow,
      isLoad: false,
      cfBg: !this.data.false
    })
  },
  //表情选择
  emojiChoose: function(e) {
    //当前输入内容和表情合并
    this.setData({
      content: this.data.content +  e.currentTarget.dataset.emoji
    })
  },
  //点击emoji背景遮罩隐藏emoji盒子
  cemojiCfBg: function() {
    this.setData({
      isShow: false,
      cfBg: false,
      isLoad: false
    })
  },
  /**
   * 评论
   */
  clickComment: function(e) {
    var id = e.currentTarget.dataset.id;
    replyObj.id = id;
    this.setData({
      commentShow: true,
      isLoad: true,
      content: "",
      replyPlaceholder: "我要评论"
    })
  },
  /**
   * 评论别人的评论
   */
  replyOther: function (e) {
    var creator = e.currentTarget.dataset.creator;
    var id = e.currentTarget.dataset.id;
    replyObj.aimUser = creator;
    replyObj.id = id;
    this.setData({
      commentShow: true,
      isLoad: true,
      content: "",
      replyPlaceholder: "回复" + creator + ":"
    })
  },
  /**
   *隐藏emoji盒子
   */
  hideEmoji: function() {
    this.setData({
      commentShow: false
    })
    console.log("隐藏emojis")
  },
  /**
   * 删除评论
   */
  deleteReply: function(e) {
    var id = e.currentTarget.dataset.replyId;
    var content = e.currentTarget.dataset.content;
    var that = this;
    wx.showModal({
      title: '提示',
      content: '是否删除评论:' + content,
      success: function(res) {
        if (res.confirm) {
          
          var opp = {};
          opp.url = "comments/" + id;
          opp.method = "PUT";
          opp.header = {
            "Content-Type": "application/json"
          };
          app.networkRequestHide(opp, function(res) {
            if (res.data.code == 0) {
              wx.showModal({
                title: '提示',
                content: '删除成功',
                showCancel: false,
                success: function(res) {
                  that.getMomentsList();
                }
              })
            }
          })
        } 
      }
    })
  }
  
})