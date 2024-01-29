package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); //트랜잭션 얻음
        tx.begin(); //트래잭션 시작

        //code
        try {
            //생성
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloB");

            //영속(영속성 컨텍스트에 정보가 저정됨)
            em.persist(member);

            //전체 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            //조건 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1) //시작 번호부터
//                    .setMaxResults(1) //끝 번호까지
//                    .getResultList(); //JPQL

//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //삭제
//            em.remove(findMember);

            //수정
//            findMember.setName("HelloJPA");

            //컨텍스트에 있는 정보를 디비에 저장
            tx.commit(); //트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
