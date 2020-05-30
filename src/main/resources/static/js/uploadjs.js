let constraintObj = { 
            audio: true, 
            video: { 
                facingMode: "user", 
                width: { min: 640, ideal: 1280, max: 1920 },
                height: { min: 480, ideal: 720, max: 1080 } 
            } 
        }; 
        // width: 1280, height: 720 -- preference only
        // facingMode: {exact: "user"}
        // facingMode: "environment"
        
        // handle older browsers that might implement getUserMedia in some way
        if (navigator.mediaDevices === undefined) {
            navigator.mediaDevices = {};
            navigator.mediaDevices.getUserMedia = function(constraintObj) {
                let getUserMedia = navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
                if (!getUserMedia) {
                    return Promise.reject(new Error('getUserMedia is not implemented in this browser'));
                }
                return new Promise(function(resolve, reject) {
                    getUserMedia.call(navigator, constraintObj, resolve, reject);
                });
            }
        }else{
            navigator.mediaDevices.enumerateDevices()
            .then(devices => {
                devices.forEach(device=>{
                    console.log(device.kind.toUpperCase(), device.label);
                    // , device.deviceId
                })
            })
            .catch(err=>{
                console.log(err.name, err.message);
            })
        }

        navigator.mediaDevices.getUserMedia(constraintObj)
        .then(function(mediaStreamObj) {
            // connect the media stream to the first video element
            let video = document.querySelector('video');
            if ("srcObject" in video) {
                video.srcObject = mediaStreamObj;
            } else {
                // old version
                video.src = window.URL.createObjectURL(mediaStreamObj);
            }
            
            video.onloadedmetadata = function(ev) {
                // show in the video element what is being captured by the
				// webcam
                video.play();
            };
            
            // add listeners for saving video/audio
            let start = document.getElementById('start');
            let stop = document.getElementById('stop');
            let startVideo = document.getElementById('startVideo');
            let vidSave = document.getElementById('vid2');
            let mediaRecorder = new MediaRecorder(mediaStreamObj);
            let chunks = [];
            
            start.addEventListener('click', (ev)=>{
            	 document.getElementById("message").innerHTML="";
            	document.getElementById("videoholder").hidden = false;
            	document.getElementById("details").hidden = true;
               // mediaRecorder.start();
                console.log(mediaRecorder.state);
            })
            
             startVideo.addEventListener('click', (ev)=>{
                mediaRecorder.start();
                console.log(mediaRecorder.state);
            })
            stop.addEventListener('click', (ev)=>{
            	document.getElementById("videoholder").hidden = true;
            	document.getElementById("details").hidden = false;
                mediaRecorder.stop();
                console.log(mediaRecorder.state);
            });
            mediaRecorder.ondataavailable = function(ev) {
                chunks.push(ev.data);
            }
            mediaRecorder.onstop = (ev)=>{
                let blob = new Blob(chunks, { 'type' : 'video/mp4;' });
                chunks = [];
                constraintObj.audio=false;
                mediaStreamObj.getTracks()[0].stop();
                mediaStreamObj.getTracks()[1].stop();
                var reader=new FileReader();
                var base64data;
                reader.readAsDataURL(blob);
                reader.onloadend=function(){
                	base64data=reader.result;
                	callAPI(base64data);
                }
               
                let videoURL = window.URL.createObjectURL(blob);
                vidSave.src = videoURL;
                document.getElementById("videoshow").hidden = false;
                
            }
        })
        .catch(function(err) { 
            console.log(err.name, err.message); 
        });
        
        /***********************************************************************
		 * getUserMedia returns a Promise resolve - returns a MediaStream Object
		 * reject returns one of the following errors AbortError - generic
		 * unknown cause NotAllowedError (SecurityError) - user rejected
		 * permissions NotFoundError - missing media track NotReadableError -
		 * user permissions given but hardware/OS error OverconstrainedError -
		 * constraint video settings preventing TypeError - audio: false, video:
		 * false
		 **********************************************************************/
 function callAPI(base64data)
 {
	 var userid=localStorage.getItem("userid");
	 var username=localStorage.getItem("username");
	    var UploadData = new Object();
	    UploadData.userId=userid;
	    UploadData.blob=base64data;
	    UploadData.username=username;
	   
	 $.ajax({
		   headers: { 
		        'Accept': 'application/json',
		        'Content-Type': 'application/json' 
		    },
	        url: "https://somethingspecial.herokuapp.com/saveblob/",
	        method: 'POST',
	        data:JSON.stringify(UploadData),
	        contentType: false,
	        processData: false,
	        success : function (data, status) {
		         console.log("Saved successfully!!");
		    
		     },
		     error : function (status) {
		    	  document.getElementById("message").innerHTML="Sorry ,Not able to save the file , upload from device or try again!!"
		     }
		    
	    });
	 
 }
 
 
 $(document).ready(function(){
	 $('#uploadfile').click(function(){ $('#datafile').trigger('click'); });
	    $("#datafile").on('change',function(){
	    	 let vidSave = document.getElementById('vid2');
	    	const file =document.getElementById('datafile').files[0];
	   	    var reader=new FileReader();
	        var base64data;
	        reader.readAsDataURL(file);
	        reader.onloadend=function(){
	        base64data=reader.result;
	        callAPI(base64data);
	        document.getElementById("message").innerHTML="Thank you for the wishes!!"
	     
	    }
	      
	});
	  
	    let save=document.getElementById("save");
	    save.addEventListener('click', (ev)=>{
        	let text=document.getElementById("wishtext").value;
        	if(text=='')
        	{
        		  document.getElementById("wishtext").style.borderColor = "red";
        	}
        	else
        	{
        		document.getElementById("wishtext").style.borderColor = "blue";
        	 $('#wishtext').val('').change();
        	  var userid=localStorage.getItem("userid");
        	  var username=localStorage.getItem("username");
      	    var WishText = new Object();
      	    WishText.userid=userid;
      	    WishText.text=text;
      	    WishText.username=username;
        	 $.ajax({
      		   headers: { 
      		        'Accept': 'application/json',
      		        'Content-Type': 'application/json' 
      		    },
      	        url: "https://somethingspecial.herokuapp.com/savewish/",
      	        method: 'POST',
      	        data:JSON.stringify(WishText),
      	        contentType: false,
  	            processData: false,
      	        success : function (data, status) {
      		         console.log("Saved successfully!!");
      		       document.getElementById("message").innerHTML="Thank you for the wishes!!"
      		    
      		     },
      		     error : function (status) {
      		    	  document.getElementById("message").innerHTML="Sorry ,Not able to save your birthday wish, try again!!"
      		     }
      		    
      	    });
        		}
        
        });
	    
	});


 
 