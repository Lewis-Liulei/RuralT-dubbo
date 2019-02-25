package rt.lewis.api.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;


@Component
public class RegUtils {
	
	@Value("${reg}")
	private String reg;
	
	private static Pattern sqlPattern;
	
	@PostConstruct
	private void init(){
		sqlPattern=Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
	}
	
	public static boolean findReg(String content){
		return sqlPattern.matcher(content).find();
	}
}
