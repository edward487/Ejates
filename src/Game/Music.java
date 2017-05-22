package Game;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

public static void play(String path, int delay, int numberOfLoops) {
		for (int i = 0; i < numberOfLoops; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						File file = new File(path);
						Clip clip = AudioSystem.getClip();
						clip.open(AudioSystem.getAudioInputStream(file));
						clip.start();
						Thread.sleep(clip.getMicrosecondLength());

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}.start();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


