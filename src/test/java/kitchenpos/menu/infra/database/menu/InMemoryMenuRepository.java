package kitchenpos.menu.infra.database.menu;

import kitchenpos.menu.domain.model.Menu;
import kitchenpos.menu.domain.repository.MenuRepository;

import java.util.*;

public class InMemoryMenuRepository implements MenuRepository {
    private final Map<Long, Menu> entities = new HashMap<>();

    @Override
    public Menu save(final Menu entity) {
        entities.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Menu> findById(final Long id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public long countByIdIn(final List<Long> ids) {
        return entities.values()
                .stream()
                .filter(entity -> ids.contains(entity.getId()))
                .count()
                ;
    }
}