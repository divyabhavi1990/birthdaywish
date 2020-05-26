 $(document).ready(function(){
    "use strict";
    var userid=localStorage.getItem("userid");
    if(userid!=null)
   {
    $.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/userLike/userid/"+userid,
	        method: 'GET',
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
	        	data.forEach(function (item) {
	        		var like=document.getElementById(item.imageid);
	        		like.setAttribute("style", "color:red;");
	        	 });
	        	
		    
		     },
		     error : function (status) {
		    	console.log("error in GET");
		     }
		    
	    });
   }
    }); 





function increaseLike(likes)
{
	
	var like=document.getElementById(likes);
	if(like.style.color=="red")
		{
		console.log("Already liked:");
		}
	
	else
    {
		var userid=localStorage.getItem("userid");
		like.setAttribute("style", "color:red;");
		var TotalLikes = new Object();
		TotalLikes.userid=userid;
		TotalLikes.imageid=likes;
		 $.ajax({
			   headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
		        url: "https://somethingspecial.herokuapp.com/totallikes/",
		        method: 'POST',
		        data:JSON.stringify(TotalLikes),
		        contentType: false,
		        processData: false,
		        success : function (data, status) {
			         console.log("Saved successfully!!");
			    
			     },
			     error : function (status) {
			    	 console.log("There is an error !!!!!");
			     }
			    
		    });
		 
	}
	
}

