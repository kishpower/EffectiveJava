package org.example.chapter4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // skipping items 15,16,17

//        item 18 : Favour Composition over Inheritance
        AudioPlayer audioPlayer = new AudioPlayer(new MP3Source());
        audioPlayer.addEffect(new VolumeAdjust(10.00));
        audioPlayer.addEffect(new Echo());
        audioPlayer.play();


//        -- anti-pattern
//        MP3Player mp3Player = new MP3Player();
//        MP3PlayerWithVolumeAdjust mp3PlayerWithVolumeAdjust = new MP3PlayerWithVolumeAdjust();

    }

    // Audio source interface
    interface AudioSource {
        byte[] readAudio();
    }

    // Concrete audio sources
    static class MP3Source implements AudioSource {
        public byte[] readAudio() {
            // Implementation to read MP3 audio
            return new byte[0]; // Simplified for example
        }
    }

    static class WAVSource implements AudioSource {
        public byte[] readAudio() {
            // Implementation to read WAV audio
            return new byte[0]; // Simplified for example
        }
    }

    // Audio effect interface
    interface AudioEffect {
        byte[] apply(byte[] audio);
    }

    // Concrete audio effects
    static class VolumeAdjust implements AudioEffect {
        private double volumeLevel;

        public VolumeAdjust(double volumeLevel) {
            this.volumeLevel = volumeLevel;
        }

        public byte[] apply(byte[] audio) {
            // Implementation to adjust volume
            return audio; // Simplified for example
        }
    }

    static class Echo implements AudioEffect {
        public byte[] apply(byte[] audio) {
            // Implementation to add echo
            return audio; // Simplified for example
        }
    }

    // Audio player using composition
    static class AudioPlayer {
        private AudioSource source;
        private List<AudioEffect> effects = new ArrayList<>();

        public AudioPlayer(AudioSource source) {
            this.source = source;
        }

        public void addEffect(AudioEffect effect) {
            effects.add(effect);
        }

        public void play() {
            byte[] audio = source.readAudio();
            for (AudioEffect effect : effects) {
                audio = effect.apply(audio);
            }
            // Code to send audio to output device
            System.out.println("Playing audio with " + effects.size() + " effects");
        }
    }

    /// Anti Pattern
    static class BasicPlayer {
        public void play() {
            // Basic implementation
        }
    }

    static class MP3Player extends BasicPlayer {
        @Override
        public void play() {
            // MP3-specific implementation
        }
    }

    static class MP3PlayerWithVolumeAdjust extends MP3Player {
        @Override
        public void play() {
            super.play();
            // Add volume adjustment
        }
    }

    static class MP3PlayerWithVolumeAdjustAndEcho extends MP3PlayerWithVolumeAdjust {
        @Override
        public void play() {
            super.play();
            // Add echo
        }
    }
}
