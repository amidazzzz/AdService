package ru.amida.advertservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.amida.advertservice.model.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
