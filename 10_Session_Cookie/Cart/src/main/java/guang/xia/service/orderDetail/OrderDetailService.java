package guang.xia.service.orderDetail;

import guang.xia.model.OderDetail;
import guang.xia.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public Iterable<OderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OderDetail save(OderDetail oderDetail) {
        return orderDetailRepository.save(oderDetail);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
