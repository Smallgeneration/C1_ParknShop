$("#loginForm").submit(function() {

    var url = "/login"; // the script where you handle the form input.

    $.ajax({
           type: "POST",
           url: url,
           data: $("#loginForm").serialize(), // serializes the form's elements.
           success: function(data)
           {
               alert(data); // show response from the php script.
           }
         });

    return false; // avoid to execute the actual submit of the form.
});