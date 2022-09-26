package peter.baseball.domain;

import peter.baseball.exception.SizeNotMatchException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by peter on 2022/09/19
 */
public class GameResultChecker {
    public GameResult checkResult(Game game, Set<Ball> answerSet) {
        if (game.getBalls().size() != answerSet.size()) {
            throw new SizeNotMatchException();
        }
        Map result = check(game.getBalls(), answerSet);

        return new GameResult(result);
    }

    private Map check(Set<Ball> questionSet, Set<Ball> answerSet) {
        Map<MatchType, Integer> resultMap = new HashMap<>();
        Iterator<Ball> questionIterator = questionSet.iterator();
        Iterator<Ball> answerIterator = answerSet.iterator();
        while(questionIterator.hasNext()) {
            Ball question = questionIterator.next();
            Ball answer = answerIterator.next();
            if (question.equals(answer)) {
                resultMap.merge(MatchType.STRIKE, 1, Integer::sum);
                continue;
            }

            if (questionSet.contains(answer)) {
                resultMap.merge(MatchType.BALL, 1, Integer::sum);
                continue;
            }

            resultMap.merge(MatchType.NOTHING, 1, Integer::sum);
        }

        return resultMap;
    }
}
