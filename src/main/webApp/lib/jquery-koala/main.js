$(function(){
  $('#main .koala').koala({
    delay: 200,
    keyup: function(event){
      log(this.value);
    }
  });

  $('#main .normal').keyup(function(event){
    log(this.value);
  });

  $("#future").koala('.koala', {
    delay: 300,
    keyup: function(event){
      log("I am from future: " + this.value);
    }
  });

  $("#add").click(function(){
    $("#future").append("<p>bind key events with koala from future: <input type='text' class='koala' /></p>");
  });

  $("#clear").click(function(){
    $("#log-box").empty();
  });

  function log(msg) {
    $("#log-box").append("<li>" + msg + "<li>");
    $("#log-box").scrollTop($("#log-box").height());
  }
});
