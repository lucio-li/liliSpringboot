var app = getApp()
var basepath = app.globalData.basepath;
var util = require("../../utils/util.js");
var emojiChar = "😋-😌-😍-😏-😜-😝-😞-😔-😪-😭-😁-😂-😃-😅-😆-👿-😒-😓-😔-😏-😖-😘-😚-😒-😡-😢-😣-😤-😢-😨-😳-😵-😷-😸-😻-😼-😽-😾-😿-🙊-🙋-🙏-✈-🚇-🚃-🚌-🍄-🍅-🍆-🍇-🍈-🍉-🍑-🍒-🍓-🐔-🐶-🐷-👦-👧-👱-👩-👰-👨-👲-👳-💃-💄-💅-💆-💇-🌹-💑-💓-💘-🚲";
Page({
  data: {
    time: "",
    location: "",
    images: [],
    content: "",
    basepath: app.globalData.basepath,
    emojiList: [],
    files: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var t = util.getNow();
    this.setData({
      time: t
    });
    var that = this;
    wx.getStorage({
      key: 'openid',
      success: function(res) {
        that.setData({
          openid: res.data
        })
      },
      fail: function() {
        wx.showModal({
          title: '提示',
          content: '宝宝先去允许授权',
        })
      }
    })
    this.splitEmoji();
  },
  /**
   * 切割emoji表情
   */
  splitEmoji: function() {
    var emojiList = emojiChar.split("-");
    this.setData({
      emojiList: emojiList
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    console.log("页面显示")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    console.log("qqq")
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },
  /**
   * 页面上点击选择图片事件的处理函数
   */
  chooseImage: function() {
    var that = this;
    wx.chooseImage({
      count: 9, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function(res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        var dataFilePaths = that.data.images;
        tempFilePaths.forEach(function(imageUrl) {

          dataFilePaths.push(imageUrl);
        })

        that.setData({
          images: dataFilePaths
        })
      }
    })
  },
  /**
   * 图片预览
   */
  previewImage: function(e) {
    var that = this;
    var index = e.currentTarget.dataset.index;
    var pictures = this.data.images;
    wx.previewImage({
      current: pictures[index],
      urls: pictures,
      fail: function() {

      },
      complete: function() {

      },
    })
  },
  deleteImageTap: function(e) {
    var index = e.currentTarget.dataset.index;
    var pictures = this.data.images;
    pictures.splice(index, 1);
    this.setData({
      images: pictures
    })
  },
  bindChooseLocation: function() {
    var that = this;
    wx.chooseLocation({
      success: function(res) {
        that.setData({
          location: res.name
        })
      }
    })

  },
  bindTextAreaBlur: function(e) {
    this.setData({
      content: e.detail.value
    })
  },
  /**
   * 上传动态的内容
   */
  bindUpload: function() {
    if (!this.data.content) {
      wx.showToast({
        title: '照片描述不能为空',
      })
      return;
    }
    var that = this;
    var options = {
      content: that.data.content,
      time: that.data.time,
      location: that.data.location,
      creator: that.data.openid
    };
    var opp = {};
    opp.url = "moments/add";
    opp.method = "post"
    opp.data = options;
    opp.header = {
      "Content-Type": "application/json"
    };
    app.networkRequest(opp, function(res) {
      if (res.data.code == 0) {
        that.data.images.forEach(function(imageUrl) {
          that.uploadAllImage(res.data.data, imageUrl);
        });
        that.setData({
          location: "",
          content: "",
          images: []
        })
        wx.showModal({
          title: '提示',
          content: '上传成功',
          showCancel: false,
          success: function() {
            wx.switchTab({
              url: '../index/index',
            })
          }
        })

      } else {
        wx.showModal({
          title: '提示',
          content: '上传失败，是否重新上传',
          success: function(res) {
            if (res.confirm) {
              that.bindUpload();
            }
          }
        })
      }

    })

  },
  /**
   * 上传照片的函数
   */
  uploadAllImage: function(momentsId, imageUrl) {
    var that = this;

    wx.uploadFile({
      url: basepath + '/moments/upload',
      filePath: imageUrl,
      name: 'file',
      formData: {
        'momentsId': momentsId
      },
      success: function(res) {
        if (res.data.code != 0) {
          console.log("上传文件失败");
        }
      },
      fail: function(e) {
        console.log("上传初次失败")
        console.log(e)
      }
    })
  },
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

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
      cfBg: false
    })
  },
  //长按删除图片
  deleteImg: function(e) {
    var item = e.currentTarget.dataset.item;
    var that = this;
    wx.showModal({
      title: '提示',
      content: '是否删除该照片',
      success: function(res) {
        if (res.confirm) {
          var images = that.data.images;
          var index = images.indexOf(item);
          if (index > -1) {
            images.splice(index, 1);
            that.setData({
              images: images
            })
          }
        }
      }
    })
  },
  /**
   * 获取当前位置
   */
  getLocation: function() {
    var that = this;
    wx.chooseLocation({
      success: function(res) {

        that.setData({
          location: res.name
        })
      },
      error: function(res) {
        console.log("获取位置失败" + res)
      }
    })
  }
})