package com.ceiba.challengue.infrastructure.repository.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ceiba.challengue.domain.model.ItemBook;
import com.ceiba.challengue.domain.repository.ItemBookRepository;

@Component
@Primary
public class MongodbItemBookRepository implements ItemBookRepository {

	private SpringDataMongodbItemBookRepository repository;
	
	@Override
	public ItemBook createItemBook(ItemBook itemBook) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
