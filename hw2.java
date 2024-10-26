// Задача 2. История посещения веб-сайтов
// Реализуйте программу для хранения и анализа историй посещений веб-сайтов. Используйте Deque для хранения истории.
// ● visitSite(String site): Добавляет сайт в историю посещений.
// ● back(int steps): Возвращает название сайта, который был посещен
// steps назад, или null, если таких шагов нет.
// ● getHistory(): Возвращает список сайтов в истории посещений, от
// последнего посещенного к первому.
// Подсказка No 1
// Для добавления сайта в историю посещений используйте метод addFirst из Deque. Это добавит сайт в начало очереди, что позволит вам хранить самые последние посещенные сайты в начале истории.
// Подсказка No 2
// Для возвращения к сайту, который был посещен steps назад, используйте метод stream вместе с skip и findFirst из Deque. Метод stream создаст поток элементов из очереди, skip пропустит первые steps элементов, а findFirst вернет первый оставшийся элемент или null, если шагов больше, чем элементов в очереди.
// Подсказка No 3
// Метод getHistory должен просто вернуть сам Deque, который уже содержит историю посещений в нужном порядке — от последнего посещенного к первому.

import java.util.Deque;
import java.util.LinkedList;
class BrowserHistory {
    private Deque<String> history = new LinkedList<>();
public void visitSite(String site) {
    history.addFirst(site);
}
public String back(int steps) {
if (steps >= history.size()) {
    return null;
}
 return
history.stream().skip(steps).findFirst().orElse(null);
}
    public Deque<String> getHistory() {
        return history;
} }
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class hw2 {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.getHistory());
    }
}