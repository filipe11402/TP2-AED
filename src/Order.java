public class Order {
    private String _orderId;

    private Integer _value;

    private String _date;

    private String _store;

    private String _partOfDay;

    private String _items;

    private String _coupon;

    public Order(String orderId, Integer value, String date, String store, String partOfDay, String items, String coupon) {
        _orderId = orderId;
        _date = date;
        _value = value;
        _store = store;
        _partOfDay = partOfDay;
        _items = items;
        _coupon = coupon;
    }

    public String getOrderId(){
        return _orderId;
    }
}
