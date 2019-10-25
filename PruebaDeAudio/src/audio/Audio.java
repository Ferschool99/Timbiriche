/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.applet.AudioClip;

/**
 *
 * @author fer_p
 */
public class Audio {
    
    public void reproducir(){
        AudioClip audio;
        audio = java.applet.Applet.newAudioClip(getClass().getResource("GameOver.wav"));
        audio.play();
    }
    
}
