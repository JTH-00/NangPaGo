import axiosInstance from './axiosInstance';

export async function getRefrigerator(page, size) {
  try {
    const response = await axiosInstance.get('/api/refrigerator', {
      params: { page, size },
    });
    return response.data.data;
  } catch (error) {
    console.error('냉장고 조회 실패:', error);
    throw error;
  }
}

export async function addIngredient(ingredientName) {
  try {
    const response = await axiosInstance.post('/api/refrigerator', null, {
      params: { ingredientName },
    });
    return response.data.data;
  } catch (error) {
    console.error('재료 추가 실패:', error);
    throw error;
  }
}

export async function searchIngredients(keyword) {
  try {
    const response = await axiosInstance.get('/api/ingredient/search', {
      params: { keyword },
    });
    return response.data.data;
  } catch (error) {
    console.error('재료 검색 실패:', error);
    throw error;
  }
}

export async function deleteIngredient(ingredientName) {
  try {
    const response = await axiosInstance.delete('/api/refrigerator', {
      params: { ingredientName },
    });
    return response.data.message;
  } catch (error) {
    console.error('재료 삭제 실패:', error);
    throw error;
  }
}
