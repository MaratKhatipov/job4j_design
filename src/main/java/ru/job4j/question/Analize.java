package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Примечание. Два пользователя считаются равными, если у них равны идентификаторы и имени.
Необходимо вычислить:
 - Сколько добавлено новых пользователей. Добавленным считается такой пользователь,
 что ранее его не было в множестве previous, но в множестве current он есть.
 - Сколько изменено пользователей. Изменённым считается объект,
 в котором изменилось имя, а id осталось прежним.
 - Сколько удалено пользователей. Удаленным считается такой пользователь,
 что ранее он был в множестве previous, но теперь в множестве current его нет.
 */
public class Analize {

	public static Info diff(Set<User> previous, Set<User> current) {
		int added = 0;
		int changed = 0;
		int deleted = 0;
		Map<Integer, String> mapChanged = new HashMap<>();
		for (User userPrevious : previous) {
			mapChanged.put(userPrevious.getId(), userPrevious.getName());
		}
		for (User userCurrent : current) {
			if (mapChanged.containsKey(userCurrent.getId())) {
				if (!mapChanged.containsValue(userCurrent.getName())) {
					changed++;
				}
			} else {
				added++;
			}
		}
		deleted = previous.size() + added - current.size();
		return new Info(added, changed, deleted);
	}


}
