$(function() {
// 在键盘按下并释放及提交后验证提交表单
    $("#registerForm").validate({
        rules: {
            registerUsername: {
                required: true,
                range: [5, 12]
            },
            registerPassword: {
                required: true,
                min: 8,
                required: true
            },
            registerRepeat: {
                required: true,
                min: 8,
                equalTo: "#registerPassword"
            },
        },
        errorPlacement: function(error, element) {
            // Append error within linked label
            $( element )
                .closest( "form" )
                .find( "label[for='" + element.attr( "id" ) + "']" )
                .append( error );
        },
        errorElement: "span"
    });
});

$('body').on('hidden.bs.modal', '.modal', function () {
    $(this).removeData('bs.modal');
    $('#registerForm').get(0).reset();
    $('span.error').remove();
});