import React, { useEffect, useRef } from 'react';
import '../../App.css';
import HeroSection from '../HeroSection';

function Home() {
  /*const outerDivRef = useRef();
  useEffect(() => {
    const wheelHandler = (e) => { 
      e.preventDefault(); 
      const { deltaY } = e;
      const { scrollTop } = outerDivRef.current; // 스크롤 위쪽 끝부분 위치
      const pageHeight = window.innerHeight;  // 100vh

      if (deltaY > 0) { // as scroll down
        if (scrollTop >= 0 && scrollTop < pageHeight) {
          // page 1
          console.log("1 page, gonna down");
          outerDivRef.current.scrollTo({
            top: pageHeight,
            left: 0,
            behavior: "smooth",
          });
        } else if (scrollTop >= pageHeight && scrollTop < pageHeight*2) {
          // page 2
          console.log("2 page, gonna down");
          outerDivRef.current.scrollTo({
            top: pageHeight*2,
            left: 0,
            behavior: "smooth",
          });
        } else {
          // page 3
          console.log("3 page, gonna down");
          outerDivRef.current.scrollTo({
            top: pageHeight*2,
            left: 0,
            behavior: "smooth",
          });
        }
      } else {  // as scroll up
        // page 1
        if (scrollTop >= 0 && scrollTop < pageHeight) {
          console.log("1 page, gonna up");
          outerDivRef.current.scrollTo({
            top: 0,
            left: 0,
            behavior: "smooth",
          });
        } else if (scrollTop >= pageHeight && scrollTop < pageHeight*2) {
          // page 2
          console.log("2 page, gonna up");
          outerDivRef.current.scrollTo({
            top: 0,
            left: 0,
            behavior: "smooth",
          });
        } else {
          // page 3
          console.log("3 page, gonna up");
          outerDivRef.current.scrollTo({
            top: pageHeight,
            left: 0,
            behavior: "smooth",
          });
        }
      }
    };
    window.onload = function() {
      const outerDivRefCurrent = outerDivRef.current;  
      outerDivRefCurrent.addEventListener("wheel", wheelHandler);
    }
    
    
    
  }, []); */
  return (
    <>
      <HeroSection />
    
    </>
      
  );
}

export default Home;
