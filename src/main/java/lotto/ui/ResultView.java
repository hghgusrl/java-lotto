package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ResultView {
    static final String WINNER_STATISTICS = "당첨 통계";
    static final String RESULT_WINNER = "%d개 일치 (%d원)- %d개\n";
    static final String TOTAL_AMOUNT = "총 수익률은 %.2f입니다.";
    static final int LOTTO_PRICE = 1000;

    public void PrintThePurchasedLotto(Lottos buyLottoList) {

        for(int i = 0; i < buyLottoList.getLottosSize(); i++) {
            Iterator<Integer> iterSet = buyLottoList.getLottoIndex(i).getLotto().iterator();
            while(iterSet.hasNext()){
                System.out.print(iterSet.next()+" ");
            }
            System.out.println();
        }
    }

    public void PrintTheWinningResults(EnumMap<Rank, Integer> resultMap, int lottoCount) {

        System.out.println(WINNER_STATISTICS);

        int sumAmount = 0;

        Set<Rank> keys = resultMap.keySet();
        for (Rank key : keys) {
            Integer value = Math.toIntExact(resultMap.get(key));
            System.out.printf(RESULT_WINNER, key.getRank(), key.getAmount(), value);
            sumAmount += value * key.getAmount();
        }

        System.out.printf(TOTAL_AMOUNT, (double) sumAmount / (lottoCount * LOTTO_PRICE));
    }
}
