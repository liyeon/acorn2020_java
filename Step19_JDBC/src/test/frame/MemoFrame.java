package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemoDao;
import test.dto.MemoDto;

/*
 *  create table memo
 *  (num number primary key,
 *  content varchar2(30),
 *  regdate date);
 *  
 *  위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를 
 *  SELECT, INSERT, UPDATE, DELETE 기능을 수행 할 수 있는 MEMOFrame을 만들어보세요
 *  
 *  조건
 * 1. num 칼럼의 값은 시퀀스를 이용해서 넣으세요
 * 2. regdate 칼럼(등록일)의 값은 sysDate를 이용해서 넣으세요
 * 3. 수정은 content만 수정 가능하게 하세요
 * 4. MemoDto, MemoDao를 만들어서 프로그래밍하세요
 */
public class MemoFrame extends JFrame implements ActionListener, PropertyChangeListener{
	private JTextField inputMemo;
	DefaultTableModel model;
	JTable table;
	public MemoFrame() {
		setLayout(new BorderLayout());
		JLabel label = new JLabel("메모");
		inputMemo = new JTextField(30);
		
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);

	
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(inputMemo);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		panel.setBackground(Color.orange);
		
		//표 형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		
		String[] colNames = {"번호", "내용", "날짜"};
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==1) {//column ==0 !|| column == 2 false
					return true;
				}
				return false;
			}
		};
		
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		displayMemo();
		
		
		table.addPropertyChangeListener(this);
	}//MemoFrame() 생성자
	
	public void displayMemo() {
		model.setRowCount(0);
		
		MemoDao dao = MemoDao.getInstance();
		
		List<MemoDto> list = dao.getList();
		for(MemoDto tmp:list) {
			Object[] row = {tmp.getNum(), tmp.getContent(), tmp.getRegdate() };
			model.addRow(row);;
		}
	}
	
	
	public static void main(String[] args) {
		MemoFrame m = new MemoFrame();
		m.setTitle("MEMOFrame");
		m.setBounds(100, 100, 700, 500);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
	}//main()


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals("save")) {
			String content = inputMemo.getText();
			MemoDto dto = new MemoDto();
			dto.setContent(content);
			
			MemoDao dao = MemoDao.getInstance();
			boolean isSuccess = dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, "메모를 추가했습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "추가에 실패했습니다.");
			}
			displayMemo();
			inputMemo.setText("");
			
		}else if(command.equals("delete")) {
			int selIndex = table.getSelectedRow();
			if(selIndex == -1) {return;}
			
			int selection = JOptionPane.showConfirmDialog(this, "선택된 row를 삭제하시겠습니까");
			if(selection!=JOptionPane.YES_OPTION) {return;}
			int num = (int)model.getValueAt(selIndex, 0);
			MemoDao dao = MemoDao.getInstance();
			dao.delete(num);
			displayMemo();
			
		}//delete
		
	}//ActionPerformed
	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	boolean tce = evt.getPropertyName().equals("tableCellEditor");
	if(tce) {
		if(isEditing) {
			int selectedIndex = table.getSelectedRow();
			int num = (int)model.getValueAt(selectedIndex, 0);
			String content = (String)model.getValueAt(selectedIndex, 1);
			String regdate = (String)model.getValueAt(selectedIndex, 2);
			
			MemoDto dto = new MemoDto(num, content, regdate);
			MemoDao.getInstance().update(dto);
			isEditing = false;
		}
		isEditing = true;
		System.out.println("property change");
		System.out.println(evt.getPropertyName());
	}
	
	}//propertyChange

}//MemoFrame
