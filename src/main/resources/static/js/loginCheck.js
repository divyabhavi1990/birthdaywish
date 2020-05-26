/**
 * 
 */
function blinker() {
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);

function sendUserName() {
	var username=document.getElementById("user").value;
	var password=document.getElementById("password").value;
	
	
	    $.ajax({
	        url: "https://somethingspecial.herokuapp.com/user/username/"+username+"/password/"+password,
	        method: 'GET',
	        success : function (data, status) {
		       if(status!="500" && data!="")
	          {
		          //location.href = "index.html"+"?username="+  username+";userid"+data.toString();
		    	 
		    	   localStorage.setItem("username", username);
		    	   localStorage.setItem("userid",data.userId);
		           localStorage.setItem("profileImage",data.userProfile.profileimage);
		           localStorage.setItem("background",data.userProfile.imagepath);
		    	 
		    	   location.href="home.html";
		    	  
	          }
	          else
	        	  {
	        	  document.getElementById("error").innerHTML="To go inside the website you have to enter creadentials details which Divya has shared !"
	        	  
	        	  }
		     },
		     error : function (status) {
		    	  document.getElementById("error").innerHTML="To go inside the website you have to enter creadentials details which Divya has shared !"
		     }
	    });
	
}
	