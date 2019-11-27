
package FarmDashBoard;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import Command.Command;
import Command.RedoManager;
import Command.UndoManager;
import Keysimulator.KeySimulater;
import ObserverPattern.AbstractItemForObserver;
import ObserverPattern.AbstractObserver;
import VisitorPattern.FarmCompoentPrice;
import VisitorPattern.FarmComponentMarketPrice;
import VisitorPattern.FarmVisitor;



public class Farm extends javax.swing.JFrame implements FarmInterface {

	private static final long serialVersionUID = 1L;

	public Farm() {
		setTitle("Farm DashBoard");
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		initComponents();
		FarmNode = null;
		FarmComponentMap = new HashMap<>();
		FarmMap = new HashMap<>();
		FarmMap.put("tree", new HashMap<>());
		FarmMap.put("data", new HashMap<>()); 
		conSub = new AbstractObserver();
		ib = new AbstractItemForObserver(this);
		conSub.Attach(ib);

		// Default input
		final Farmanalyzer farmanalyzer = new Farmanalyzer();
		final FarmContainer root = (FarmContainer) farmanalyzer.getInstance("FarmContainer");
		root.FarmInitialize("farm", 52.0);
		FarmComponentMap.put("farm", root);
		final FarmContainer container = (FarmContainer) farmanalyzer.getInstance("FarmContainer");
		container.FarmInitialize("container", 52);
		FarmComponentMap.put("container", container);

		root.getFarmList().add(container);

	}

	private void initComponents() {

		FarmcomponentPrice = new JLabel();
		FarmcomponentInsert = new javax.swing.JButton();
		buttonGroup.add(FarmcomponentInsert);
		ErrorShow = new javax.swing.JLabel();
		FarmComponentCount = new JLabel();
		FarmPrice = new javax.swing.JLabel();
		FarmComponentCount_1 = new javax.swing.JLabel();
		FarmLog = new DefaultListModel<>();
		Undo = new javax.swing.JButton();
		buttonGroup.add(Undo);
		Redo = new javax.swing.JButton();
		buttonGroup.add(Redo);
		FarmCurrentPrices = new javax.swing.JLabel();
		FarmComponentCurrentPrice = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		FarmcomponentInsert.setText("Insert");
		FarmcomponentInsert.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				addRootActionPerformed(evt);
			}
		});

		final javax.swing.tree.DefaultMutableTreeNode FarmNode = new javax.swing.tree.DefaultMutableTreeNode("root");
		final javax.swing.tree.DefaultMutableTreeNode FarmNode1 = new javax.swing.tree.DefaultMutableTreeNode(
				"container");
		javax.swing.tree.DefaultMutableTreeNode FarmNode3 = new javax.swing.tree.DefaultMutableTreeNode("item1");
		FarmNode1.add(FarmNode3);
		FarmNode3 = new javax.swing.tree.DefaultMutableTreeNode("item2");
		FarmNode1.add(FarmNode3);
		FarmNode.add(FarmNode1);

		ErrorShow.setForeground(new java.awt.Color(0, 0, 0));

		FarmPrice.setText("Current Price");

		FarmComponentCount_1.setText("Total Items");

		Undo.setText("Undo");
		Undo.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				UndoActionPerformed(evt);
			}
		});

		Redo.setText("Redo");
		Redo.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				RedoActionPerformed(evt);
			}
		});

		FarmCurrentPrices.setText("Current Market Price");

		final JSplitPane FarmPane = new JSplitPane();

		UpdateFarm = new JButton("Update");
		buttonGroup.add(UpdateFarm);
		UpdateFarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ib.update();
				final int count = ib.getFarmItemDetails();
				FarmComponentCount.setText(Integer.toString(count));

			}
		});
		
		JButton flight = new JButton("FlightSimulator");
		flight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame();
				KeySimulater s = new KeySimulater();
				f.add(s);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(600,400);
				f.setVisible(true);

				
				
			}
		});

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(298)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(FarmcomponentInsert, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(flight))
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(FarmPrice, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addGap(12)
									.addComponent(FarmPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
											.addComponent(FarmCurrentPrices, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(FarmComponentCurrentPrice, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
											.addComponent(FarmComponentCount_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
											.addGap(43)
											.addComponent(FarmComponentCount, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addGap(34))
										.addGroup(layout.createSequentialGroup()
											.addGap(107)
											.addComponent(FarmcomponentPrice, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
											.addGap(18)))
									.addGap(66)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(UpdateFarm)
									.addGap(130))
								.addComponent(ErrorShow, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(544, Short.MAX_VALUE)
					.addComponent(Undo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Redo)
					.addGap(282))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(60)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(ErrorShow, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
								.addComponent(FarmcomponentInsert)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(flight))
							.addComponent(FarmPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Undo)
						.addComponent(Redo))
					.addGap(26)
					.addComponent(FarmPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(UpdateFarm)
							.addGap(64))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(FarmCurrentPrices)
								.addComponent(FarmComponentCurrentPrice, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(FarmComponentCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(FarmComponentCount_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(30)))
					.addGap(51))
				.addGroup(layout.createSequentialGroup()
					.addGap(324)
					.addComponent(FarmcomponentPrice, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(147))
		);
		FarmRoot = new javax.swing.JTree();
		FarmPane.setLeftComponent(FarmRoot);
		FarmRoot.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("farm") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
			}
		}));
		FarmlogList = new javax.swing.JList<>(FarmLog);
		FarmPane.setRightComponent(FarmlogList);
		FarmRoot.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(final java.awt.event.MouseEvent evt) {
				treeWorldMouseClicked(evt);
			}
		});
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void addRootActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bAAdRootActionPerformed
		final TreePath path = FarmRoot.getSelectionPath();
		ComponentInsert nw = null;
		DefaultMutableTreeNode selectedNode = null;

		ErrorShow.setText("");
		if (path == null)
			JOptionPane.showMessageDialog(null, "Please select item!");
		else {
			selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();

			if (!selectedNode.toString().equals("farm")
					&& FarmComponentMap.get(selectedNode.toString()).getClass().getName().equals("model.Item"))
				JOptionPane.showMessageDialog(null, "You cannot add to item ");
			else {
				nw = new FarmComponentInsert(this);
				nw.DashboardItem();
			}
			conSub.notifyObservers();
		}
	}// GEN-LAST:event_bAAdRootActionPerformed

	private void treeWorldMouseClicked(final java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		final TreeSelectionModel smd = FarmRoot.getSelectionModel();
		if (smd.getSelectionCount() > 0) {

			final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) FarmRoot.getSelectionPath()
					.getLastPathComponent();
			final Node selectedObj = (Node) FarmComponentMap.get(selectedNode.toString());
			final FarmVisitor cmVisitor = new FarmComponentMarketPrice();
			final FarmVisitor cpVisitor = new FarmCompoentPrice();
			final double cmv = selectedObj.accept(cmVisitor);
			final double cpv = selectedObj.accept(cpVisitor);
			FarmcomponentPrice.setText(String.valueOf(cpv));
			FarmComponentCurrentPrice.setText(String.valueOf(cmv));

		} // GEN-LAST:event_treeWorldMouseClicked
	}

	private void UndoActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_UndoActionPerformed
		// TODO add your handling code here:
		final String LogMSG = FarmlogList.getSelectedValue();
		if (LogMSG == null) {

			JOptionPane.showMessageDialog(null, "Choose a FarmLog record to redo!");
			return;
		}
		final Command undoCommand = new UndoManager(this, LogMSG);
		undoCommand.execute();
		((DefaultTreeModel) FarmRoot.getModel()).reload();
	}// GEN-LAST:event_UndoActionPerformed

	private void RedoActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RedoActionPerformed
		// TODO add your handling code here:
		final String LogMSG = FarmlogList.getSelectedValue();
		if (LogMSG == null) {

			JOptionPane.showMessageDialog(null, "Choose a FarmLog record to redo!");
			return;
		}
		final Command redoCommand = new RedoManager(this, LogMSG);
		redoCommand.execute();
		FarmLog.removeElement(LogMSG);
		((DefaultTreeModel) FarmRoot.getModel()).reload();
	}

	public static void main(final String args[]) {

		try {
			for (final javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (final ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Farm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (final InstantiationException ex) {
			java.util.logging.Logger.getLogger(Farm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (final IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Farm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (final javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Farm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Farm.getInstance().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton Redo;
	private javax.swing.JButton Undo;
	private javax.swing.JButton FarmcomponentInsert;
	private javax.swing.JLabel FarmPrice;
	private javax.swing.JLabel FarmComponentCount_1;
	private javax.swing.JLabel FarmCurrentPrices;
	private javax.swing.JList<String> FarmlogList;
	private javax.swing.DefaultListModel<String> FarmLog;
	private JLabel FarmComponentCount;
	private javax.swing.JLabel ErrorShow;
	private JLabel FarmComponentCurrentPrice;
	private JLabel FarmcomponentPrice;
	private javax.swing.JTree FarmRoot;
	// End of variables declaration//GEN-END:variables

	private Map<String, Object> FarmComponentMap;
	private final Map<String, Map<String, Object>> FarmMap;
	private Node FarmNode;
	private static Farm instance;
	private final AbstractObserver conSub;
	private final AbstractItemForObserver ib;
	private JButton UpdateFarm;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// singleton implementation
	public static Farm getInstance() {
		if (instance == null)
			instance = new Farm();
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#getLogmap()
	 */
	@Override
	public Map<String, Map<String, Object>> getLogmap() {
		return FarmMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#getNodemap()
	 */
	@Override
	public Map<String, Object> getNodemap() {
		return FarmComponentMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#setNodemap(java.util.Map)
	 */
	@Override
	public void setNodemap(final Map<String, Object> FarmComponentMap) {
		this.FarmComponentMap = FarmComponentMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#getNewnode()
	 */
	@Override
	public Node getNewnode() {
		return FarmNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#setNewnode(FarmDashBoard.Node)
	 */
	@Override
	public void setNewnode(final Node FarmNode) {
		this.FarmNode = FarmNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#getTreeWorld()
	 */
	@Override
	public JTree getTreeWorld() {
		return FarmRoot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#getLog()
	 */
	@Override
	public DefaultListModel<String> getLog() {
		return FarmLog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see FarmDashBoard.FarmInterface#setLog(javax.swing.DefaultListModel)
	 */
	@Override
	public void setLog(final DefaultListModel<String> log) {
		this.FarmLog = log;
	}
}
//end
