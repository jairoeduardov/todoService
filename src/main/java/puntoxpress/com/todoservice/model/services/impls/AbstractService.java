package puntoxpress.com.todoservice.model.services.impls;

import puntoxpress.com.todoservice.model.dto.AbstractDto;
import puntoxpress.com.todoservice.model.entities.AbstractEntity;
import puntoxpress.com.todoservice.model.repositories.BaseRepository;

import java.io.Serializable;


public class AbstractService <T extends AbstractEntity, K extends AbstractDto, ID extends Serializable> {

    private final BaseRepository<T, ID> baseRepository;



    @Override
    public T save(T entity) {
        return (T)baseRepository.save(entity);
    }

    @Override
    public K save(T entity, Class<K> typeParameter) {
        if( entity.getUuid().isEmpty() ) entity.setUuid(UUID.randomUUID().toString());
        return modelMapper.map((T)baseRepository.save(entity), typeParameter);
    }

    public K save(K dto, Class<T> t, Class<K> k) {
        if( dto.getUuid() == null || dto.getUuid().isEmpty() ) dto.setUuid(UUID.randomUUID().toString());
        T entity = modelMapper.map( dto, t);
        T newT = baseRepository.save(entity);
        return (K) modelMapper.map( newT, k ) ;
    }

    @Override
    public List<T> findAll(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<T> pages = baseRepository.findAll(pageable);
        return pages.getContent();
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<K> findAll(Class<K> t) {
        List<T> entities = baseRepository.findAll();
        return entities.stream().map( e -> modelMapper.map( e, t )).collect(Collectors.toList());
    }

	    /*
	    @Override
		public Optional<T> findById(ID entityId) {
	        return baseRepository.findById(entityId);
	    }
	    */

    @Override
    public T findByUuid(String uuid){
        return baseRepository.findByUuid(uuid)
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), uuid)) );
    }

    @Override
    public K findByUuid(String uuid, Class<K> typeParameter){
        T t = baseRepository.findByUuid(uuid)
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), uuid)) );

        return modelMapper.map(t, typeParameter);
    }

    @Override
    public T update(T entity) {
        T t = baseRepository.findByUuid(entity.getUuid())
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), entity.getUuid())) );
        return (T) baseRepository.save(t);
    }

    @Override
    public K update(T entity, Class<K> typeParameter) {
        T t = baseRepository.findByUuid(entity.getUuid())
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), entity.getUuid())) );
        return modelMapper.map( (T) baseRepository.save(t), typeParameter);
    }


    public K update(K dto,   Class<T> t, Class<K> k) {
        //T entity = modelMapper.map( dto, t);
        T entity = baseRepository.findByUuid(dto.getUuid())
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), dto.getUuid() )) );

        modelMapper.map( dto, entity );
        //newT.setId(entity.getId());

        return (K) modelMapper.map( baseRepository.save(entity) , k ) ;
    }

    @Override
    public T updateById(T entity, ID entityId) {
        Optional<T> optional = baseRepository.findById(entityId);
        entity.setId((Long) entityId);
        if(optional.isPresent()){
            return (T) baseRepository.save(entity);
        }else{
            return null;
        }
    }

    @Override
    public K updateById(T entity, ID entityId, Class<K> typeParamer) {
        Optional<T> optional = baseRepository.findById(entityId);
        if(optional.isPresent()){
            return (K) modelMapper.map( baseRepository.save(entity), typeParamer);
        }else{
            return null;
        }
    }

    @Override
    public void delete(T entity) {
        baseRepository.delete(entity);
    }

    @Override
    public void deleteById(ID entityId) {
        baseRepository.deleteById(entityId);
    }

    @Override
    public void deleteByUuid(String uuid) {
        T t = baseRepository.findByUuid(uuid)
                .orElseThrow( () -> new NoSuchElementException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), uuid )) );

        baseRepository.delete(t);
    }

    private String getLocalMessage(String key, String... params){
        return messageSource.getMessage(key,
                params,
                Locale.ENGLISH);

//String message = messageSource.getMessage("item.absent", null, "Default message if item.absent not found", locale);
    }

    public BaseRepository<T, ID> getBaseRepository() {
        return baseRepository;
    }

    public void setBaseRepository(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }




}