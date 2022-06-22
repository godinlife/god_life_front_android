import React from 'react';
import '../App.css';
import './HeroSection.css';
import Jump from 'react-reveal/Jump';

function HeroSection() {
  return (
    <div className='hero-container'>

      <h1>테스트 페이지 입니다</h1>
      
        <div className='hero-btns'>
          <Jump>
            아래로 스크롤해서 계속
          </Jump>
        </div>
        
    </div>
  );
}

export default HeroSection;
