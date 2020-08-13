package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.CardPayment;
import com.nt.entity.CashPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveData() {
		  Session ses=null;
		  Transaction tx=null;
		  boolean flag=false;
		  CardPayment cardPayment=null;
		  ChequePayment chequePayment=null;
		  CashPayment cashPayment=null;
		 
		//get Session
		  ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
			//prepre objects
			cardPayment=new CardPayment();
			cardPayment.setPayeeName("karan");
			cardPayment.setAmount(9000);
			cardPayment.setCardBankName("SBI");
			cardPayment.setCardNo(53454666);
			cardPayment.setCardType("CREDIT");
			
			chequePayment=new ChequePayment();
			chequePayment.setPayeeName("ramesh");
			chequePayment.setAmount(10000);
			chequePayment.setChequeBankName("CITI");
			chequePayment.setChequeNo(534534534);
			chequePayment.setChequeType("SELF");
			
			cashPayment =new CashPayment();
			cashPayment.setPayeeName("suresh");
			cashPayment.setAmount(90000);
			cashPayment.setWitness("jani");
			cashPayment.setLocation("hyd");
			cashPayment.setDenominations("2000*10 ,500*40");
			
			ses.save(cardPayment); ses.save(chequePayment);
			ses.save(cashPayment);
			
			flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//Tx Mgmt
			if(flag) {
				tx.commit();
				System.out.println("objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("objects are not saved");
			}
			//close objs
			HibernateUtil.closeSession(ses);
		}//method
	}//class

	@Override
	public void loadData() {
	  Session ses=null;
	  Payment payment=null;
	  List<Payment> list1=null;
	  List<CardPayment> list2=null;
	  List<ChequePayment> list3=null;
	  List<CashPayment> list4=null;
	  Query query=null;
	  try {
		  //get SEssion object
		  ses=HibernateUtil.getSession();
		  //Load objects
		  query=ses.createQuery("from Payment");
		  list1=query.getResultList();
		  list1.forEach(payment1->{
			  System.out.println(payment1);
		  });
		  System.out.println(".....................");
		  query=ses.createQuery("from CardPayment");
		  list2=query.getResultList();
		  list2.forEach(card->{
			  System.out.println(card);
		  });
		  System.out.println(".....................");
		  query=ses.createQuery("from ChequePayment");
		  list3=query.getResultList();
		  list3.forEach(cheque->{
			  System.out.println(cheque);
		  });
		  
		  System.out.println(".....................");
		  query=ses.createQuery("from CashPayment");
		  list4=query.getResultList();
		  list4.forEach(cash->{
			  System.out.println(cash);
		  });
		  
	  }//try
	  catch(HibernateException he) {
		  he.printStackTrace();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	  finally {
		  HibernateUtil.closeSession(ses);
	  }

	}//method
}//class
