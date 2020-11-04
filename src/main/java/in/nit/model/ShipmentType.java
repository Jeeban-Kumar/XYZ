package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shipment_type_tab")
public class ShipmentType {
	@Id
	//@GeneratedValue //-> hibernate generate the common seq for all tables
	@GeneratedValue(generator = "shipmenttype_seq_name")
	@SequenceGenerator(name = "shipmenttype_seq_name",sequenceName = "shipmenttype_seq")
	@Column(name = "ship_id_col")
	private Integer id;
	@Column(name = "shipment_mode_col",length = 10,nullable = false)
	private String shipmentMode;
	@Column(name = "shipment_code_col",length = 10,nullable = false)
	private String shipmentCode;
	@Column(name = "enable_shipment_col",length = 5,nullable = false)
	private String enableShipment;
	@Column(name = "shipment_grade_col",length = 2,nullable = false)
	private String shipmentGrade;
	@Column(name = "description_col",length = 100,nullable = false)
	private String description;
}
