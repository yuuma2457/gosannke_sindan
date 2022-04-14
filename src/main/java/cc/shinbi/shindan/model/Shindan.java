package cc.shinbi.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	 List<Result> results;
	 List<Question> questions;
	
	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}
	
	public List<Result> getResuluts() {
		return results;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	
	
	public void shuffle() {
		for(Question question : this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}
	
	
	private static List<Result> getResultList(){
		Result[] results = {
				new Result(
						"ヒトカゲ",
						"あなたは情熱的なリーダーです。"
						),
				new Result(
						"ゼニガメ",
						"あなたは感受性豊かな芸術家です。"
						),
				new Result(
						"フシギダネ",
						"あなたは優しく思いやりがあります。"
						),
				new Result(
						"ピカチュウ",
						"あなたは頭脳派です。名探偵になれるかも"
						)
		};
		List<Result> list = Arrays.asList(results);
		return list;
	}
	
	
	private static List<Question> getQuestionList(){
		List<Question> list = new ArrayList<Question>();
		
		
		Question question1 = new Question("q1", "次の中でもっとも大切なものは？");
		question1.addItem(0, "自分");
		question1.addItem(1, "お金");
		question1.addItem(2, "友人・家族");
		question1.addItem(3, "時間");
		list.add(question1);
		
		
		Question question2 = new Question("q2", "この中であなたがもっとも使う生活費は？");
		question2.addItem(0, "ガス代");
		question2.addItem(1, "水道代");
		question2.addItem(2, "食費");
		question2.addItem(3, "電気代");
		list.add(question2);
		
		Question question3 = new Question("q3", "この中でもっとも好きな食べ物");
		question3.addItem(0, "麻婆豆腐");
		question3.addItem(1, "寿司");
		question3.addItem(2, "ステーキ");
		question3.addItem(3, "ケーキ");
		list.add(question3);
		
		Question question4 = new Question("q4", "デートするならどこ");
		question4.addItem(0, "遊園地");
		question4.addItem(1, "ショッピングモール");
		question4.addItem(2, "映画館");
		question4.addItem(3, "美術館・博物館");
		list.add(question4);
		
		Question question5 = new Question("q5", "この中で旅行に行くならどこ");
		question5.addItem(0, "スペイン");
		question5.addItem(1, "イタリア");
		question5.addItem(2, "フランス");
		question5.addItem(3, "イギリス");
		list.add(question5);
		
		return list;
	}
	
	public static Shindan createShindan() {
		Shindan shindan = new Shindan();
		
		List<Result> results = getResultList();
		shindan.getResuluts().addAll(results);
		
		List<Question> questions = getQuestionList();
		shindan.getQuestions().addAll(questions);
		
		
		shindan.shuffle();
		
		return shindan;
	}
	
	public Result check(List<Integer> answers) {
		int[] counters = new int[this.results.size()];
		Arrays.fill(counters,0);
		
		for(Integer index : answers) {
			counters[index]++;
		}
		
		int index = 0;
		int maxCount = 0;
		for(int i = 0; i < counters.length; i++) {
			int counter = counters[i];
			if(counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}
		
		return this.results.get(index);
	}
}
