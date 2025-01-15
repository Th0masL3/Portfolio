import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/consoles');
  await page.getByRole('cell', { name: '67881d2254a55a3e915237bd' }).click();
  await expect(page.getByRole('row', { name: '67881d2354a55a3e915237e4 The' }).getByRole('button').nth(1)).toBeVisible();
  await expect(page.getByText('The Legend of Zelda: A Link')).toBeVisible();
  await page.getByRole('row', { name: '67881d2354a55a3e915237e4 The' }).getByRole('button').nth(1).click();
  await page.getByRole('link', { name: 'carticon' }).click();
  
});