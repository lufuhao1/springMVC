$(function () {
    $('#login').click(function () {
    	console.info($('#password').val());
        $.ajax({
            url: 'userLogin.do',
            data: {
                account: $('#account').val(),
                password: $('#password').val()
            },
            method: 'post',
            dataType: 'json',
            success: function (data, status, XHR) {
                console.log(data);
                if ('1' == data.counter) {
                    layer.msg('登录成功');
                  Cookies.set('user', data.id);
                   window.location.href = '111.html';
                } else {
                    layer.msg('账号或密码错误');
               }
              /*  if (data.message == 'OK') {
                	window.location.href = 'index.html'
                }*/
            },
            error: function (XHR, status, error) {
                console.log(error);
            },
        });
    });
});
