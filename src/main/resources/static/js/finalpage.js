$(document).ready(function() {
	
	$.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/getwishes/",
	        method: 'GET',
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
	        	data.forEach(function (item) {
	       		 let blobs = new Blob();
	       		blobs=b64toBlob(item.blob);
	       		let videoURL = window.URL.createObjectURL(blobs);
	       			var oldmsg=$('#wish').html();
	       		  $('#wish').html(oldmsg+'<div class="col-lg-4 col-md-6 col-sm-12"><div class="single-team-member"><h3 style="color: #4e9a66;font-style: italic;font-weight: 700;font-size: large;font-family:Engagement cursive;"><i class="fa fa-smile-o fa-2x" aria-hidden="true" style="color:brown";></i> '+item.username+' says: <i class="fa fa-smile-o" aria-hidden="true" style="color:brown;"></i></h3><video muted="muted" style="width: 410px;height: 300px;object-position: top;" controls src='+videoURL+'></video></div></div>');
	       			  
	        	 });
	        	
		     },
		     error : function (status) {
		    	console.log("error in GET");
		     }
		    
	    });
	
	
	
	$.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/getwishtext/",
	        method: 'GET',
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
	        	data.forEach(function (item) {
	        		console.log("text--"+item.text)
	       			var oldmsg=$('#wishtextget').html();
	       		  $('#wishtextget').html(oldmsg+'<div class="col-lg-4 col-md-6 col-sm-12"><div class="single-team-member" style="border-color:#332d2dd9;border: 3px solid #63595c91;;"><div class="family-img" ><span><span style="color:brown;font-weight: 900;font-style: oblique;font-family: Engagement cursive;">'+item.username+': </span>'+item.text+'</span></div></div></div>');
	       		
	        	 });
	        	
		     },
		     error : function (status) {
		    	console.log("error in GET");
		     }
		    
	    });

});


function b64toBlob(dataURI) {

    var byteString = atob(dataURI.split(',')[1]);
    var ab = new ArrayBuffer(byteString.length);
    var ia = new Uint8Array(ab);

    for (var i = 0; i < byteString.length; i++) {
        ia[i] = byteString.charCodeAt(i);
    }
    return new Blob([ab], { 'type' : 'video/mp4;' });
}
