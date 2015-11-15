package adcore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class MySqlPartition {
	public static void main(String[] args) {
		createSql("ad_click", new Date(), 180);
	}

	
	static void createSql(String table,Date calendarBegin,int days){
		System.out.println("ALTER TABLE `"+table+"`");
		System.out.println("PARTITION BY RANGE (id)");
		System.out.println("(");
		for (int i = 0; i < days; i++) {
			Date date = DateUtils.addDays(calendarBegin, i);
			DateFormat format = new SimpleDateFormat("yyMMdd");
			long datePre = Long.parseLong(format.format(date));

			 System.out.println("PARTITION p"+datePre+" VALUES LESS THAN  ("+datePre+"000000000000) ,");
		}
		
		
		
		System.out.println("PARTITION  pmax  VALUES LESS THAN MAXVALUE");
		System.out.println(");");
		
		
		
		System.out.println();
	}
}
