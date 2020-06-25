package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{
	JTextField inputName;
	JTextField inputAddr;
	JTable table;
	DefaultTableModel model;
	//생성자
	public MemberFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);
		JLabel label2 = new JLabel("주소");
		inputAddr = new JTextField(10);
		
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);

		//삭제버튼 추가
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		
		add(panel, BorderLayout.NORTH);
		
		panel.setBackground(Color.orange);
		
		//표 형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		
		//칼럼명을 String[] 에 순서대로 준비
		String[] colNames = {"번호", "이름", "주소"};
		
		//테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 개수)
		model = new DefaultTableModel(colNames, 0) {
			//인자로 전달되는 행(row), 열(column) 수정 가능 여부를 리턴하느 ㄴ메소드
			@Override
			public boolean isCellEditable(int row, int column) {
				//만일 첫번째(0번째)칼럼이면 수정이 불가하도록 한다.
				if(column==0) {
					return false;
				}
				
				return true;
			}
		};
		
		//모델을 테이블에 연결한다.
		table.setModel(model);
		
		//스크롤이 가능하도록 테이블을 JSCrollPane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		
		//JScrollPane을 프레임 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		table.setGridColor(Color.CYAN);
		table.setBackground(Color.PINK);
	    Font font = new Font("맑은 고딕", Font.BOLD, 15);
	    table.setFont(font);
	    
		displayMember();
		
		//테이블에서 발생하는 이벤트 리스너 등록하기
		table.addPropertyChangeListener(this);//값이 바뀌는지 감시
	}//생성자
	
	//테이블에 회원 목록을 출력하는 메소드
	public void displayMember() {
		//row개수를 강제로 0으로 지정해서 삭제한다.
		model.setRowCount(0);
		//회원목록을 얻어와서
		MemberDao dao = MemberDao.getInstance();
		
		List<MemberDto> list = dao.getList();
		for(MemberDto tmp:list) {
			//MemberDto 객체에 저장된 정보를 Object[] 객체에 순서대로 담는다.
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr() };
			model.addRow(row);;
		}
//		for(int i=0; i<list.size(); i++) {
//			MemberDto tmp = list.get(i);
//			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr() };
//			model.addRow(row);;
//		}//for
		
	}//displayMember()
	
	
	
	
	
	public static void main(String[] args) {
		MemberFrame f = new MemberFrame();
		f.setTitle("나의 프레임");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}//main()
	@Override
	public void actionPerformed(ActionEvent e) {
		//액션command 읽어오기
		String command = e.getActionCommand();
		if(command.equals("save")) {
			//입력한 문자열을 읽어와서
			String name = inputName.getText();
			String addr = inputAddr.getText();
			//MemberDto 객체에 담아서
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//MemberDao 객체를 이용해서 DB에 저장
			MemberDao dao = MemberDao.getInstance();
			boolean isSuccess = dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name + " 님의 정보를 추가했습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "추가에 실패했습니다.");
			}
			
			
			//JTable에 목록 다시 출력하기
			displayMember();
			
			inputName.setText("");
			inputAddr.setText("");
			
		}else if(command.equals("delete")) {
			
			//1. 선택된 row 인덱스를 읽어온다.
			int selectedIndex = table.getSelectedRow();
			if(selectedIndex==-1) {
				//선택된 row가 없다면
				return;//메소드를 여기서 끝내라(리턴해라)
			}

			//실제 삭제 할 것인지 확인한다.
			int selection = JOptionPane.showConfirmDialog(this, "선택된 row를 삭제하시곘습니까?");
			if(selection != JOptionPane.YES_OPTION) {return;}
			//2. 선택된 row의 첫번째 칼럼의 숫자를 읽어온다.(삭제할 회원의 번호)
			int num= (int)model.getValueAt(selectedIndex,0);//실제 데이터는 model이 가직 있고 Object type을 가지고 있다. 그래서 캐스팅해쥼
			//3. MemberDao 객체를 이용해서 해당 회원의 정보를 삭제
			MemberDao dao = MemberDao.getInstance();
			dao.delete(num);
			//4. table 에 회원 목록 다시 출력하기
			displayMember();
		}
	}//action

	boolean isEditing = false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {//수정중일때
				//변화된 값을 읽어와서 DB에 반영한다.
				//수정된 칼럼에 있는 row전체의 값을 읽어온다
				int selectedIndex = table.getSelectedRow();
				int num = (int)model.getValueAt(selectedIndex, 0);
				String name = (String)model.getValueAt(selectedIndex, 1);
				String addr = (String)model.getValueAt(selectedIndex, 2);
				//수정할 회원의 정보를 MemberDto 객체에 담고
				MemberDto dto = new MemberDto(num, name, addr);
				//db에 저장하기
				MemberDao.getInstance().update(dto);
				isEditing = false;//수정중이 아니라고 표시한다.
			}//if
			isEditing = true; //수정중이라고 표시한다.
			System.out.println("property change");
			System.out.println(evt.getPropertyName());
		}//if
	}//propertyChange
}//class
