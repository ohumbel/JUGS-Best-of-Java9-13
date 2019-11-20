package exercises.part1_2;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Beispielprogramm für den Workshop "Java 9 Hands On" / das Buch "Java 9 -- Die Neuerungen"
 * 
 * @author Michael Inden
 * 
 * Copyright 2017/2018 by Michael Inden 
 */
public class Exercise4_Optional
{
    public static void main(final String[] args)
    {
        final Optional<String> optCustomer = multiFindCustomerJdk8("Tim");
        optCustomer.ifPresentOrElse(str -> System.out.println("8 found: " + str), 
                                    () -> System.out.println("8 not found"));

        final Optional<String> optCustomer2 = multiFindCustomerJdk9("Tim");
        optCustomer2.ifPresentOrElse(str -> System.out.println("9 found: " + str), 
                                     () -> System.out.println("9 not found"));

        final Optional<String> optCustomer3 = multiFindCustomerJdk9("UNKNOWNs");
        optCustomer3.ifPresentOrElse(str -> System.out.println("9 found: " + str), 
                                     () -> System.out.println("9 not found"));
    }

	private static Optional<String> multiFindCustomerJdk9(final String customerId)
    {
		return findInCache(customerId)
				.or(() -> findInMemory(customerId))
				.or(() -> findInDb(customerId));
    }
    
    private static Optional<String> multiFindCustomerJdk8(final String customerId)
    {
        final Optional<String> opt1 = findInCache(customerId);

        if (opt1.isPresent())
        {
            return opt1;
        }
        else
        {
            final Optional<String> opt2 = findInMemory(customerId);

            if (opt2.isPresent())
            {
                return opt2;
            }
            else
            {
                return findInDb(customerId);
            }
        }
    }

    private static Optional<String> findInMemory(final String customerId)
    {
        //System.out.println("findInMemory");
        final Stream<String> customers = Stream.of("Tim", "Tom", "Mike", "Andy");
        
        return customers.filter(name -> name.contains(customerId))
                        .findFirst();
    }
    
    private static Optional<String> findInCache(final String customerId)
    {
        //System.out.println("findInCache");
        return Optional.empty();
    }

    private static Optional<String> findInDb(final String customerId)
    {
        //System.out.println("findInDb");
        return Optional.empty();
    }
}
