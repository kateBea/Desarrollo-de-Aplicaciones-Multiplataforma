function llamarControlador()
{
$.ajax({
        url: "http://localhost:8080/customers/byid/2"
    }).then(function(data) {
       $('.customer-id').append(data.id);
       $('.customer-lastName').append(data.lastName);
    });
}