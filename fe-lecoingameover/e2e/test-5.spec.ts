import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:3000/');
  await page.getByRole('button', { name: 'Console Icon' }).click();
  await page.getByRole('cell', { name: 'NES', exact: true }).click();
  await expect(page.getByRole('row', { name: '675f7b8f5b45be63899a1a7c' }).getByRole('button').nth(1)).toBeVisible();
  await page.getByRole('row', { name: '675f7b8f5b45be63899a1a7c' }).getByRole('button').nth(1).click();
});