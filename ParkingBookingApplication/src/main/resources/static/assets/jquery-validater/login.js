/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
$(function () {
    var $formLogin = $("#validater-formlogin");
    if ($formLogin.length) {
        $formLogin.validate({
            rules: {
                "username": {
                    required: true,
                    maxlength: 6, 
                    maxlength: 15
                },
                "password":{
                    required: true
                }
            },
            messages: {
                username: {
                    required: 'Username is required',
                    minlength: 'Min 6 charracter',
                    maxlength: 'Max 25 charracter',
                }
            }
        })
    }

})


