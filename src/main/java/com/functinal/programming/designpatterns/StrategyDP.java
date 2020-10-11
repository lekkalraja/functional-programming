package com.functinal.programming.designpatterns;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * Strategy Design Pattern is a Behavioural Design pattern
 *  - It is used when we have multiple solution or algorithms to solve a specific task
 *    and client decides the specific implementation which is to be used at runtime
 */
public class StrategyDP {

    public static void main(String[] args) {
        List<Stock> stocks = new ArrayList<>();
        stocks.add(Stock.builder().symbol("AAPL").price(318.65).units(10).build());
        stocks.add(Stock.builder().symbol("MSFT").price(166.86).units(45).build());
        stocks.add(Stock.builder().symbol("Google").price(99).units(12.5).build());
        stocks.add(Stock.builder().symbol("AMZ").price(1866.74).units(45).build());
        stocks.add(Stock.builder().symbol("GOOGL").price(1480.20).units(3.5).build());
        stocks.add(Stock.builder().symbol("AAPL").price(318.65).units(8).build());
        stocks.add(Stock.builder().symbol("AMZ").price(1866.74).units(9).build());

        /*StockFilter.bySymbol(stocks, "AMZ").forEach(System.out::println);
        System.out.println("============================================");
        StockFilter.byPriceAbove(stocks, 500).forEach(System.out::println);*/

        // STRATEGIES
        StockFilter.filter(stocks, stock -> stock.getSymbol().equals("AMZ")).forEach(System.out::println);
        System.out.println("===========================================================================");
        StockFilter.filter(stocks, stock -> stock.getPrice() > 500).forEach(System.out::println);
    }

    static class StockFilter {
       /* public static List<Stock> bySymbol(List<Stock> stocks, String symbol) {
            List<Stock> filteredData = new ArrayList<>();
            for (Stock stock: stocks) {
                if(stock.getSymbol().equals(symbol)) {
                    filteredData.add(stock);
                }
            }
            return filteredData;
        }

        public static List<Stock> byPriceAbove(List<Stock> stocks, double price) {
            List<Stock> filteredStocks = new ArrayList<>();
            for (Stock stock: stocks) {
                if(stock.getPrice() > price) {
                    filteredStocks.add(stock);
                }
            }
            return filteredStocks;
        }*/

        public static  List<Stock> filter(List<Stock> stocks, Predicate<Stock> strategy) {
            List<Stock> filteredStocks = new ArrayList<>();
            for (Stock stock: stocks) {
                if(strategy.test(stock)) {
                    filteredStocks.add(stock);
                }
            }
            return filteredStocks;
        }
    }

    @Builder @Getter @ToString
    static class Stock {
        private final String symbol;
        private final double price;
        private final double units;
    }
}
