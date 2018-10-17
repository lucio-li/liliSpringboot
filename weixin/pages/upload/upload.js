var app = getApp()
var basepath = app.globalData.basepath;
Page({
  data: {
    time: "",
    location: "",
    hasImages:false,
    images: [],
    content: "",
    basepath: app.globalData.basepath,
    emojis: ["00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134"],
    files: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var nowTime = new Date();
    var m = nowTime.getMonth() + 1;
    var d = nowTime.getDate();
    var h = nowTime.getHours();
    var minutes = nowTime.getMinutes();
    var s = nowTime.getSeconds();
    if (m < 10) {
      m = "0" + m;
    }
    if (d < 10) {
      d ="0" + d;
    }
    if (h < 10) {
      h = "0" + h;
    }
    if (minutes < 10) {
      minutes = "0" + minutes;
    }
    if (s < 10) {
      s = "0" + s;
    }
    var t = nowTime.getFullYear() + "-" + m + "-"
      + d + " " + h + ":"
      + minutes + ":" + s;
    this.setData({
      time: t
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("页面显示")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    console.log("qqq")
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },
  /**
   * 页面上点击选择图片事件的处理函数
   */
  chooseImage: function () {
    var that = this;
    wx.chooseImage({
      count: 9, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        var dataFilePaths = that.data.images;
        tempFilePaths.forEach(function (imageUrl) {
          
          dataFilePaths.push(imageUrl);
        })
        
        that.setData({
          images: dataFilePaths
        })
      }
    })
  },
  clickImage: function (e) {
    var that = this;
    var index = e.currentTarget.dataset.index;
    var pictures = this.data.images;
    console.log(pictures[index])
    wx.previewImage({
      current: pictures[index],
      urls: pictures,
      fail: function () {
        
      },
      complete: function () {
        
      },
    })
  },
  deleteImageTap: function (e) {
    var index = e.currentTarget.dataset.index;
    var pictures = this.data.images;
    pictures.splice(index, 1);
    this.setData({
      images: pictures
    })
  },
  bindChooseLocation: function () {
    var that = this;
    wx.chooseLocation({
      success: function (res) {
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
  bindUpload: function () {
    var that = this;
    wx.navigateTo({
      url: '../index/index'
    })
    var that = this;
    var options = {
      avatarUrl: app.globalData.userInfo.avatarUrl,
      time: that.data.time,
      location: that.data.location,
      content: that.data.content
    };
    var opp = {};
    opp.url = "upload/content";
    opp.data = options;
    opp.header = { "Content-Type": "application/json" };
    app.networkRequest(opp, function (res) {
      that.data.images.forEach(function (imageUrl) {
        that.uploadAllImage(res.data.directory, imageUrl);
      });
    })
    
  },
  /**
   * 上传照片的函数
   */
  uploadAllImage: function (directory, imageUrl) {
    var that = this;
    
    wx.uploadFile({
      url: basepath + '/upload/image', 
      filePath: imageUrl,
      name: 'file',
      formData: {
        'directory': directory
      },
      success: function (res) {
        var data = res.data
        console.log("上传照片成功" + res.data)
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
  onShareAppMessage: function () {
  
  },
  //点击表情显示隐藏表情盒子
  emojiShowHide: function () {
    this.setData({
      isShow: !this.data.isShow,
      isLoad: false,
      cfBg: !this.data.false
    })
  },
  //表情选择
  emojiChoose: function (e) {
    console.log(e.currentTarget.dataset.emoji)
    //当前输入内容和表情合并
    this.setData({
      content: this.data.content + "[" + e.currentTarget.dataset.emoji + "]"
    })
  },
  //点击emoji背景遮罩隐藏emoji盒子
  cemojiCfBg: function () {
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
  }
})