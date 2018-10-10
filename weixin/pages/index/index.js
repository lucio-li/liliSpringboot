var app = getApp()
Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    list: [1,2,3],
    moments: null,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    avatarUrlList: [],
    commentHidden: true,
    focus:false,
    momentTime: '',
    contentDetail: '',
    basepath: app.globalData.basepath,
    authorizeShow: false //授权窗口是否显示   

  },
  //事件处理函数,跳转上传照片
  bindViewTap: function() {
    wx.navigateTo({
      url: '../upload/upload'
    })
  },
  onLoad: function () {
    var that = this;
    // this.getMomentsList();
    // wx.navigateTo({
    //   url: '../logs/logs'
    // })
  },
  /**
 * 生命周期函数--监听页面显示
 */
  onShow: function () {
    this.getMomentsList();
    this.getUserInfo();
  },
  /**
   * 授权获取用户信息
   */
  getUserInfo: function() {
    var that = this;
    wx.getUserInfo({
      success: function (res) {
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
  getUserMessage: function (data) {
    console.log(data)
    var userInfo = JSON.parse(data.detail.rawData)
    var nickName = userInfo.nickName
    var avatarUrl = userInfo.avatarUrl
    this.setData({
      authorizeShow: false
    })
    that.updateUser(nickName, avatarUrl);
  },
  /**
   * 新增或者更新用户
   */
  updateUser: function (nickName, avatarUrl) {
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
        opp.header = { "Content-Type": "application/json" };
        app.networkRequestHide(opp, function (res) {
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
  getMomentsList :function () {
    var that =  this;
    var options = {};
    var opp = {};
    opp.url = "moments/list";
    opp.data = options;
    opp.header = { "Content-Type": "application/json" };
    app.networkRequest(opp, function (res) {
      that.setData({
        moments: res.data.momentsList,
        avatarUrlList: res.data.avatarUrlList,
        hideFlag: true
      })
    })
  },
  /**
   * 点击图片实现预览
   */
  clickImage: function (e) {
    var that = this;
    var index = e.currentTarget.dataset.index;
    wx.previewImage({
      current: index,
      urls: [index],
      fail: function () {

      },
      complete: function () {

      },
    })
  },
  /**
   * 删除动态
   */
  deleteMoment: function (e) {
    var index = e.currentTarget.dataset.index;
    var moments = this.data.moments;
    console.log(moments[index].time);
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确定要删除吗？',
      success: function (sm) {
        if (sm.confirm) {
          // 用户点击了确定 可以调用删除方法了
        
          var options = {};
          options.time = moments[index].time;
          var opp = {};
          opp.url = "moments/deleteOne";
          opp.data = options;
          opp.header = { "Content-Type": "application/json" };
          app.networkRequest(opp, function (res) {
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
   * 评论动态
   */
  clickComment: function(e) {
    var index = e.currentTarget.dataset.index;
    var moments = this.data.moments;
    this.setData({
      commentHidden:false,
      focus:true,
      momentTime: moments[index].time
    })
    console.log(this.data.userInfo)
  },
  editComment: function () {
    
  },
  /**
   * 评论输入框失去焦点隐藏
   */
  bindBlurComment: function () {
    this.setData({
      commentHidden: true,
      focus: false
    })
  },
  /**
   * 发送评论的消息
   */
  sendComment: function () {
    var that = this;
    var options = {
      momentsTime: this.data.momentTime,
      name: this.data.userInfo.nickName,
      contentDetail: this.data.contentDetail
    };
    var opp = {};
    opp.url = "comments/add";
    opp.data = options;
    opp.header = { "Content-Type": "application/json" };
    app.networkRequest(opp, function (res) {
      that.getMomentsList();
    })
    


  },
  /**
   * 评论输入框的改变事件
   */
  bindTextAreaBlur: function (e) {
    this.setData({
      contentDetail: e.detail.value
    })
  },

  /**
   * 页面相关事件处理函数--监听下拉刷新
   */
  onPullDownRefresh: function () {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getMomentsList();
  },
})

