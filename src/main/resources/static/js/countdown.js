(function($) {
    "use strict";
  var activeTab = localStorage.getItem('activeTab');
  console.log(activeTab);

  if (activeTab) {
     $('a[href="' + activeTab + '"]').addClass('active');
  }
  
  var prevactiveTab = localStorage.getItem('prevactiveTab');
  console.log(prevactiveTab);

  if (prevactiveTab) {
     $('a[href="' + prevactiveTab + '"]').removeClass('active');
  }
    var deadline = new Date("June 3, 2020").getTime(); 
    var x = setInterval(function() { 
    var now = new Date().getTime(); 
    var t = deadline - now; 
    var days = Math.floor(t / (1000 * 60 * 60 * 24)); 
    var hours = Math.floor((t%(1000 * 60 * 60 * 24))/(1000 * 60 * 60)); 
    var minutes = Math.floor((t % (1000 * 60 * 60)) / (1000 * 60)); 
    var seconds = Math.floor((t % (1000 * 60)) / 1000); 
    document.getElementById("headerCountdown").innerHTML = days + "d " 
    + hours + "h " + minutes + "m " + seconds + "s "; 
    	
    }, 1000); 
}(jQuery));

$('.navbar-nav li a').click(function(e) {
  
    $('a').removeClass('active');
    $(this).addClass('active');
    localStorage.setItem('activeTab', $(e.target).attr('href'));
    localStorage.setItem('prevactiveTab', $('a').attr('href'));
});


function logout()
{
	window.localStorage.clear();
	location.href="index.html";
}

