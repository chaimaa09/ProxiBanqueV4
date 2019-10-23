package ma.jit.proxibanque.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.OperationRepository;
import ma.jit.proxibanque.entities.Operation;

@Service
public class OperationMetierImpl implements IOperationMetier {

	@Autowired
	OperationRepository operationRepository;
	
	@Override
	public List<Operation> getAll() {
		// TODO Auto-generated method stub
		return operationRepository.findAll();
	}

	@Override
	public Operation addOperation(Operation operation) {
		// TODO Auto-generated method stub
		return operationRepository.save(operation);
	}

}
