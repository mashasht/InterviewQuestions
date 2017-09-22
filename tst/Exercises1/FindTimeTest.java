package Exercises1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.google.common.collect.Range;

public class FindTimeTest {
	
	@Test
	public void testOneSchedule() {
		LocalDateTime todayNine = LocalDateTime.of(2017, 9, 17, 21, 0);
		LocalDateTime todayEleven = LocalDateTime.of(2017, 9, 17, 23, 0);
		Range<LocalDateTime> nineToTwelve = Range.closed(todayNine, todayEleven);
		Optional<Range<LocalDateTime>> breakTime = FindTime.findTime(Collections.singletonList(nineToTwelve));
		assertFalse(breakTime.isPresent());
	}
	
	@Test
	public void testTwoSchedules_returnsBreak() {
		LocalDateTime todayNine = LocalDateTime.of(2017, 9, 17, 21, 0);
		LocalDateTime todayEleven = LocalDateTime.of(2017, 9, 17, 23, 0);
		
		LocalDateTime todayTwelve = LocalDateTime.of(2017, 9, 17, 12, 0);
		LocalDateTime todayTwo = LocalDateTime.of(2017, 9, 17, 14, 0);
		
		Range<LocalDateTime> result = Range.closedOpen(todayTwo, todayNine);
		Range<LocalDateTime> nineToEleven = Range.closed(todayNine, todayEleven);
		Range<LocalDateTime> twelveToTwo = Range.closed(todayTwelve, todayTwo);
		List<Range<LocalDateTime>> schedules = new ArrayList<>();
		schedules.add(nineToEleven);
		schedules.add(twelveToTwo);
		Optional<Range<LocalDateTime>> breakTime = FindTime.findTime(schedules);
		assertEquals(breakTime.get(), result);
	}

}
