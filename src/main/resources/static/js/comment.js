
var commentData=[];
var test=[];
var total=[];

function addComment(id,imageid,name)
{
	var activeimg = document.getElementById(imageid).src;
	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById(id);

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal 
	btn.onclick = function() {
	
	  modal.style.display = "block";
	  document.getElementById("activeimage").src=activeimg;
	  test.forEach(function (item) {
		
		  if(item.imageid==name)
		{
			var oldmsg=$('#dynamiccontent').html();
		  $('#dynamiccontent').html(oldmsg+'<p>'+'<b>'+item.username+'</b>'+': '+item.comment+'</p>');
		}
			  
 	 });
	  
	  total.forEach(function (item) {
			
		  if(item.imageid==name)
		{
			  $('#totalshow').html('<i class="fa fa-thumbs-up" aria-hidden="true" style="color: brown;"></i>'+' '+item.totalLikes);
		}
			  
 	 });
	  
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		
		if(commentData.length>0)
		{
		savealldata(name);
		commentData=[];
		}
	 $('#dynamiccontent').html("");
	  modal.style.display = "none";
	}
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}

}



function saveComment()
{
	var username=localStorage.getItem("username");
    var msg=$('#newcomment').val();
    commentData.push(msg);
    var oldmsg=$('#dynamiccontent').html();
    $('#dynamiccontent').html(oldmsg+'<p>'+'<b>'+username+'</b>'+': '+msg+'</p>');
    $('#newcomment').val('').change();
  
}

$(document).ready(function() {
	commentData=[];
	$('#newcomment').emojioneArea({
		pickerPosition:"bottom"
	});
	
    $.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/loadstory",
	        method: 'GET',
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
	        	
	        	test=data;
	        	
		     },
		     error : function (status) {
		    	console.log("error in GET");
		     }
		    
	    });
    gettotal();
});

function savealldata(imageid)
{
	 var userid=localStorage.getItem("userid");
	 var username=localStorage.getItem("username");
	    var CommentSave = new Object();
	    CommentSave.userid=userid;
	    CommentSave.imageid=imageid;
	    CommentSave.username=username;
	    CommentSave.comments=commentData;
	   
	  
	 $.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/savecomments",
	        method: 'POST',
	        data:JSON.stringify(CommentSave),
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
		         console.log("Saved successfully!!");
		    
		     },
		     error : function (status) {
		    	 console.log("Something is wrong!!")
		     }
		    
	    });
	 
}

function gettotal()
{
	

    $.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/gettotallikes/",
	        method: 'GET',
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
	        	
	        	total=data;
	        	
		     },
		     error : function (status) {
		    	console.log("error in GET");
		     }
		    
	    });
}


