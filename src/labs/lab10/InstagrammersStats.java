package labs.lab10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
/**
 * A class for performing various analyses on a set of Instagrammers data
 *
 */
public class InstagrammersStats {
	static List<Instagrammer> igList1;
	static List<Instagrammer> igList2;
	static List<Instagrammer> igList3;
	static List<Instagrammer> igList4;
	static List<Instagrammer> igListBLANK;
	
	/**
	 * Given a Stream of Instagrammers and a country, return the top Instagrammer
	 * (by rank) in the given country. If there are no Instagrammers in that country,
	 * return an empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	country			country to search for
	 * 
	 * @return	top Instagrammer in country, or empty Optional, if none in country
	 */
	public static Optional<Instagrammer> problem1_getTopIGerInCountry(Stream<Instagrammer> instagrammers,
			String country) {
		Optional<Instagrammer> result = instagrammers.filter(w->w.getCountry().equals(country))
		 .sorted((p,n)->p.getRank()-n.getRank())
		 .findFirst();
		return result; // FIX ME
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a category, return a List containing the 
	 * Instagrammer(s) in that category with the most followers. The list should only 
	 * contain multiple Instagrammers if there are multiple Instagrammers who have the 
	 * most followers. The order of the list should follow the order in which those 
	 * Instagrammers appear in the stream.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category to search for
	 * 
	 * @return	List containing top Instagrammer(s) in category
	 */
	public static List<Instagrammer> problem2_getMostFollowedIGerInCategory(Stream<Instagrammer> instagrammers,
			String category) {
		Map<Long, List<Instagrammer>> groupOfList = instagrammers.filter(w->w.getCategory().equals(category))
				.collect(Collectors.groupingBy(Instagrammer::getNumFollowers))
				;
		if (groupOfList.isEmpty()) {
			return new ArrayList<Instagrammer>();
		}
		long maxnumber = groupOfList.keySet().stream().max((p,n)->Long.compare(p, n)).get();
		List<Instagrammer> result = groupOfList.get(maxnumber);
		return result; // FIX ME
	}
	
	
	
	/**
	 * Given a Stream of Instagrammers, return a String that contains the names of all countries
	 * represented by the Instagrammers, ordered lexicographically, each name separated by ", ".
	 * Do not include blank country names.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a String containing the names of all countries represented in the stream, each name
	 * separated by ", "
	 */
	public static String problem3_getAllCountries(Stream<Instagrammer> instagrammers) {
		Set<String> resultset = instagrammers.map(w->w.getCountry())
		.collect(Collectors.toSet());
		List<String> resultlist = new ArrayList();
		resultlist.addAll(resultset);
		resultlist.remove("");
		Collections.sort(resultlist);
		String result = String.join(", ", resultlist);
		return result; // FIX ME
	}
	

	/**
	 * Given a Stream of Instagrammers and a category String, return the number of Instagrammers in
	 * a category that contains the given category String (case-insensitive).
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	category		category search string
	 * 
	 * @return	number of Instagrammers in a category that contains the given category String (case-insensitive)
	 */
	public static long problem4_countIGersInCategory(Stream<Instagrammer> instagrammers, String category) {
		long result = instagrammers.filter(w->(w.getCategory()).toLowerCase().contains(category.toLowerCase()))
				.count();
		return result; // FIX ME
	}
	

	
	
	
	/**
	 * Given a Stream of Instragrammers, return a Map<String, Double> that maps each country to
	 * the average Instagrammer rank in that country
	 * 
	 * This map should be sorted lexicographically by country name.
	 * 
	 * If the stream is empty, return an empty map.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * 
	 * @return	a mapping of country to average Instagrammer rank in that country
	 */
	public static Map<String, Double> problem5_getAvgRankPerCountry(Stream<Instagrammer> instagrammers) {
		Map<String, Double> result = instagrammers.collect(Collectors.groupingBy(w->w.getCountry(),Collectors.averagingDouble(Instagrammer::getRank)));
		Map<String, Double> sortedMap = new TreeMap<String, Double>(result);
		return sortedMap; // FIX ME
	}
	

	
	
	/**
	 * Given a Stream of Instagrammers, return a list of all categories, ordered from most
	 * frequent to least frequent. If two categories have the same number of Instagrammers,
	 * order them lexicographically by their category names.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * 
	 * @return	a list of all categories, ordered from most frequent to least frequent
	 */
	public static List<String> problem6_getCategories(Stream<Instagrammer> instagrammers) {
		Map<String, Long> groupOfList = instagrammers
				.collect(Collectors.groupingBy(w->w.getCategory(),Collectors.counting()));
		Map<String, Long> sortedMap = groupOfList.entrySet().stream()
			       .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
			    		   .thenComparing(Map.Entry.comparingByKey()))
			       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		List<String> resultlist = new ArrayList();
		resultlist.addAll(sortedMap.keySet());
		
		return resultlist; // FIX ME
	}
	
	public static void main(String args[]) {
		String path = "src/"; //<- Assign the path of the .csv files to this variable. Do not include the file name, 
		// it will be added below.
		igList1 = InstagrammersReader.readFile(path + "top_instagrammers.csv");
		igList2 = InstagrammersReader.readFile(path + "top_instagrammers2.csv");
		igList3 = InstagrammersReader.readFile(path + "top_instagrammers3.csv");
		igList4 = InstagrammersReader.readFile(path + "top_instagrammers4.csv");
		igListBLANK = InstagrammersReader.readFile(path + "top_instagrammersBLANK.csv");
		System.out.println(problem7_getTopNCountries(igList1.stream(), 9));

	}
	
	
	/**
	 * Given a Stream of Instagrammers and an integer n, return a list of the top n countries, 
	 * sorted in descending order by number of Instagrammers. If two countries have the same number
	 * of Instagrammers, order them lexicographically by country name. Ignore blank country
	 * names.
	 * 
	 * If there are < n countries represented in the stream, return them all, sorted in the order
	 * previously stated.
	 * 
	 * @param instagrammers		stream of Instagrammers
	 * @param n					number of results desired
	 * 
	 * @return	a list of the top n countries
	 */
	public static List<String> problem7_getTopNCountries(Stream<Instagrammer> instagrammers, int n) {
		Map<String, Long> groupOfList = instagrammers
				.filter(w->!w.getCountry().equals(""))
				.collect(Collectors.groupingBy(w->w.getCountry(),Collectors.counting()));
		Map<String, Long> sortedMap = groupOfList.entrySet().stream()
			       .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
			    		   .thenComparing(Map.Entry.comparingByKey()))
			       .limit(n)
			       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		List<String> resultlist = new ArrayList();
		resultlist.addAll(sortedMap.keySet());
		
		return resultlist; // FIX ME
	}
	
	
	/**
	 * Given a Stream of Instagrammers and two integers (min and max), return a String that 
	 * contains the names of all Instagrammers with an engagement number within that range,
	 * ordered lexicographically, each name separated by a single space
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	min				min engagement
	 * @param	max				max engagement
	 */
	public static String problem8_getAllIGersInEngagementRange(Stream<Instagrammer> instagrammers, 
			int min, int max) {
		List<String> resultList = instagrammers.filter(w->(w.getEngagement()<=max) && (w.getEngagement()>=min))
				.map(w->w.getName())
				.collect(Collectors.toList());
		
		Collections.sort(resultList);
		String result = String.join(" ", resultList);
		return result; // FIX ME
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a string, return the first Instagrammer found 
	 * in the stream whose name contains that string (case-sensitive). 
	 * 
	 * If no Instagrammer name contains the string, or the stream is empty, return an 
	 * empty Optional<Instagrammer>
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	str				search string
	 * 
	 * @return	first Instagrammer found whose name contains the string (case-sensitive)
	 */
	public static Optional<Instagrammer> problem9_getFirstIGerContainingString(Stream<Instagrammer> instagrammers, 
			String str) {
		Optional<Instagrammer> result =  instagrammers
				.filter(w->w.getName().contains(str))
				.findFirst();
		return result; // FIX ME
	}
	
	
	/**
	 * Given a Stream of Instagrammers and a boolean value distinct, return the number
	 * of Instagrammers in the stream, excluding duplicates if distinct is true.
	 * 
	 * A duplicate Instagrammer is one with the same name as another Instagrammer.
	 * 
	 * @param	instagrammers	stream of Instagrammers
	 * @param	distinct		whether or not to exclude duplicates
	 * 
	 * @return	the number of Instagrammers in the stream
	 */
	public static long problem10_countInstagrammers(Stream<Instagrammer> instagrammers, 
			boolean distinct) {
		long result =0;
		if (distinct) {
			result=instagrammers.distinct().count();
		}else {
			result = instagrammers.count();
		}
		return result; // FIX ME
	}
}