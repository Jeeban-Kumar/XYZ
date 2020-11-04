package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="order_method_tab")
public class OrderMethod {
	@Id
	@GeneratedValue(generator = "om_gen")
	@SequenceGenerator(name = "om_gen",sequenceName = "om_seq_gen")
	@Column(name = "om_id_col")
	private Integer id;
	@Column(name = "om_mode_col")
	private String orderMode;
	@Column(name = "om_code_col")
	private String orderCode;
	@Column(name = "om_type_col")
	private String orderType;
	@ElementCollection
	@CollectionTable(name = "ord_acpt_tab",
					joinColumns = @JoinColumn(name="om_id_col"))
	@Column(name = "ord_acpt_col")
	private List<String> orderAccept;
	@Column(name = "desc_col")
	private String description;
}
