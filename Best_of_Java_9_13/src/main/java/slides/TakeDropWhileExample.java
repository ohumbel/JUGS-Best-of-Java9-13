package slides;
import java.util.stream.Stream;

public class TakeDropWhileExample 
{
	public static void main(String[] args) 
	{
		Stream<String> words = Stream.of("ab", "BLA", "Xy", "<START>",
										"WELCOME", "TO", "ORACLE", "CODE ONE",
										"<END>", "x", "y", "z");
			
		Stream<String> extracted = words.dropWhile(str -> !str.startsWith("<START>")).
				                         skip(1).
				                         takeWhile(str -> !str.startsWith("<END>"));
	
		extracted.forEach(System.out::println);
	}
}
