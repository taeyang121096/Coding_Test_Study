package Programmers;

//fees : 기본시간, 기본요금, 단위시간, 단위요금
//record 시각 차량번호 내역
import java.util.*;

class ParkingFee_Prog {
	public int[] solution(int[] fees, String[] records) {

		Map<String, Integer> parking = new HashMap<>();
		Map<String, Integer> times = new HashMap<>();
		ArrayList<String> cars = new ArrayList<>();

		for (String record : records) {
			String[] str = record.split(" ");
			int time = hourToMin(str[0]); // 입차 시간
			String car = str[1]; // 차번호

			if (!cars.contains(car)) {
				cars.add(car);
				times.put(car, 0);
			}

			// 출차
			if (parking.containsKey(car)) {
				times.put(car, times.get(car) + (time - parking.get(car)));
				parking.remove(car);
			} else { // 입차
				parking.put(car, time);
			}

		}

		int[] answer = new int[cars.size()];
		Collections.sort(cars);
		int deadline = hourToMin("23:59");

		for (int i = 0; i < cars.size(); i++) {
			answer[i] = fees[1];
			String car = cars.get(i);

			int time = times.get(car) - fees[0];
			// 출차 x
			if (parking.containsKey(car)) {
				time += (deadline - parking.get(car));
			}
			// 요금 정산
			if (time > 0) {
				answer[i] += (Math.ceil(time / (double) (fees[2])) * fees[3]);
			}
		}

		return answer;
	}

	public int hourToMin(String time) {
		String[] tmp = time.split(":");
		int hour = Integer.parseInt(tmp[0]) * 60;
		int minute = Integer.parseInt(tmp[1]);
		return hour + minute;
	}
}
