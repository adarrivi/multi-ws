package com.adarrivi.multiws.api.endpoint;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.adarrivi.multiws.api.exception.TimeDelayerException;

@Component
public class RandomComponent {

	private static final Random RANDOM = new Random();

	public void pauseCurrentThreadExecutionShort() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new TimeDelayerException("Cannot complete the thread pause", e);
		}
	}

	public void pauseCurrentThreadExecutionLong() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new TimeDelayerException("Cannot complete the thread pause", e);
		}
	}

	public boolean randomBoolean() {
		return RANDOM.nextBoolean();
	}

	public void pauseCurrentThreadRandomLength() {
		if (randomBoolean()) {
			pauseCurrentThreadExecutionShort();
		} else {
			pauseCurrentThreadExecutionLong();
		}
	}

	public <T> List<T> getRandomSubSet(int size, List<T> list) {
		Collections.shuffle(list);
		return list.subList(0, size);
	}

	public <T> T anyItem(List<T> list) {
		return list.get(RANDOM.nextInt(list.size()));
	}
}
