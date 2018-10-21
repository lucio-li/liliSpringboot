const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}
function getNow() {
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
    d = "0" + d;
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
  return t;
}
module.exports = {
  formatTime: formatTime,
  getNow: getNow
}
