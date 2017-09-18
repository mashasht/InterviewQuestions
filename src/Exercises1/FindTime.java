package Exercises1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.google.common.collect.Range;

public class FindTime {
	public static Range<LocalDateTime> findTime(List<Range<LocalDateTime>> schedules) {
		if (schedules == null || schedules.isEmpty())
			return null;
		schedules.sort((Range<LocalDateTime> r1, Range<LocalDateTime> r2) -> r1.lowerEndpoint().compareTo(r2.lowerEndpoint()));
		Range<LocalDateTime> connectedSchedules = Range.closed(schedules.get(0).lowerEndpoint(), schedules.get(0).upperEndpoint());
		for(Range<LocalDateTime> range: schedules) {
			if (connectedSchedules.isConnected(range)) {
				connectedSchedules = connectedSchedules.intersection(range);
			}
			else {
				if (ChronoUnit.MINUTES.between(connectedSchedules.upperEndpoint(), range.lowerEndpoint()) >= 15){
					return Range.closedOpen(connectedSchedules.upperEndpoint(), range.lowerEndpoint());
				}
				connectedSchedules = range;
			}
		}
		return null;
	}
}
