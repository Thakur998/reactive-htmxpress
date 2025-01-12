var music;
var current;

function loadId(){
        form.querySelector("input[name='client-id']").value = window.crypto.randomUUID();
        console.log(form.querySelector("input[name='client-id']").value)
}
                    
window.onload = function() {
         loadId();
         createPoller();
};

function getCurrentMusicFile() {
   return document.getElementById('player-slider').name;
}

function playMusic(){
    var changed = document.getElementById('music-player');
    console.log(changed);
    if (music != undefined && music != null && music.currentSrc == changed.currentSrc) {
        music.play();
    } else {
        if(music != null && music != undefined) {
        music.pause();}
        music = document.getElementById('music-player')
        music.play();
    }

 }


function pauseMusic() {
 if (music != undefined && music != null) {
    music.pause();
 }
}

function getMusic() {
    return music;
}


